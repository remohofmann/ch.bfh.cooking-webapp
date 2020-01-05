package ch.bfh.ti.cookingWebapp.persistence.service;


import ch.bfh.ti.cookingWebapp.persistence.model.RecipeIngredientCombination;
import ch.bfh.ti.cookingWebapp.persistence.model.RecipeTagCombination;
import ch.bfh.ti.cookingWebapp.persistence.model.Ingredient;
import ch.bfh.ti.cookingWebapp.persistence.model.Recipe;
import ch.bfh.ti.cookingWebapp.persistence.model.Tag;
import ch.bfh.ti.cookingWebapp.persistence.repository.RecipeIngredientRepository;
import ch.bfh.ti.cookingWebapp.persistence.repository.RecipeRepository;
import ch.bfh.ti.cookingWebapp.persistence.repository.RecipeTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServices {
    private RecipeRepository recipeRepository;
    private RecipeTagRepository recipeTagRepository;
    private RecipeIngredientRepository recipeIngredientRepository;
    private IngredientServices ingredientServices;
    private TagServices tagServices;
    private long lastId;

    @Autowired
    public RecipeServices(RecipeRepository recipeRepository,
                          RecipeTagRepository recipeTagRepository,
                          RecipeIngredientRepository recipeIngredientRepository,
                          IngredientServices ingredientServices,
                          TagServices tagServices) {
        super();
        this.recipeRepository = recipeRepository;
        this.recipeTagRepository = recipeTagRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.ingredientServices = ingredientServices;
        this.tagServices = tagServices;
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        this.recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    public List<Recipe> getFirstThreeRecipes() {
        List<Recipe> allRecipes = new ArrayList<>();
        this.recipeRepository.findAll().forEach(allRecipes::add);
        List<Recipe> recipes = new ArrayList<>();

        recipes.add(allRecipes.get(0));
        recipes.add(allRecipes.get(1));
        recipes.add(allRecipes.get(2));

        return recipes;
    }

    public Recipe getSingleRecipe() {
        List<Recipe> allRecipes = new ArrayList<>();
        this.recipeRepository.findAll().forEach(allRecipes::add);

        return allRecipes.get(0);
    }

    public List<RecipeTagCombination> getAllRecipeTagCombinations() {
        List<RecipeTagCombination> recipeTags = new ArrayList<>();
        this.recipeTagRepository.findAll().forEach(recipeTags::add);
        return recipeTags;
    }

    public List<RecipeIngredientCombination> getAllRecipeIngredientCombinations() {
        List<RecipeIngredientCombination> recipeIngredients = new ArrayList<>();
        this.recipeIngredientRepository.findAll().forEach(recipeIngredients::add);
        return recipeIngredients;
    }

    public Recipe getRecipeById(Long recipeId){
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        return recipe.orElse(null);
    }

    //Searches ingredients for recipe ID
    public List<Ingredient> getIngredientsForRecipeId(Long recipeId){
        List<RecipeIngredientCombination> recipeIngredients = getAllRecipeIngredientCombinations();
        recipeIngredients.removeIf(c -> !(c.getRecipeId().equals(recipeId)));
        List<Ingredient> ingredients = new ArrayList<>();
        for (RecipeIngredientCombination i: recipeIngredients) {
            ingredients.add(ingredientServices.getIngredientById(i.getIngredientId()));
        }
        return ingredients;
    }

    //Searches tags for recipe ID
    public List<Tag> getTagsForRecipeId(Long recipeId){
        List<RecipeTagCombination> recipeTags = getAllRecipeTagCombinations();
        recipeTags.removeIf(t -> !(t.getRecipeId().equals(recipeId)));
        List<Tag> tags = new ArrayList<>();
        for (RecipeTagCombination c: recipeTags) {
            tags.add(tagServices.getTagById(c.getTagId()));
        }
        return tags;
    }

    //Searches for Recipes by tag.
    public List<Recipe> getRecipesByTag(Tag tag) {
        List<Recipe> recipes = new ArrayList<>();
        List<RecipeTagCombination> recipeTags = getAllRecipeTagCombinations();
        for (RecipeTagCombination c:recipeTags){
            if (c.getTagId().equals(tag.getId())){
                recipes.add(getRecipeById(c.getRecipeId()));
            }
        }
        return recipes;
    }

    //Searches for Recipes by multiple tags.
    public List<Recipe> getRecipesByTags(List<Tag> tags) {
        List<Recipe> recipes = new ArrayList<>();
        List<RecipeTagCombination> recipeTags = getAllRecipeTagCombinations();
        for (RecipeTagCombination c:recipeTags) {
            for (Tag t:tags){
                if (c.getTagId().equals(t.getId())) {
                    Recipe recipe = getRecipeById(c.getRecipeId());
                    if (!recipes.contains(recipe)){
                        recipes.add(recipe);
                    }
                }
            }
        }
        return recipes;
    }

    //Searches for Recipes by Ingredient.
    public List<Recipe> getRecipesByIngredient(Ingredient ingredient) {
        List<Recipe> recipes = new ArrayList<>();
        List<RecipeIngredientCombination> recipeIngredients = getAllRecipeIngredientCombinations();
        for (RecipeIngredientCombination c:recipeIngredients){
            if (c.getIngredientId().equals(ingredient.getId())){
                recipes.add(getRecipeById(c.getRecipeId()));
            }
        }
        return recipes;
    }

    //Searches for Recipes by multiple Ingredients.
    public List<Recipe> getRecipesByIngredients(List<Ingredient> ingredients) {
        List<Recipe> recipes = new ArrayList<>();
        List<RecipeIngredientCombination> recipeIngredients = getAllRecipeIngredientCombinations();
        for (RecipeIngredientCombination c:recipeIngredients){
            for (Ingredient i:ingredients){
                if (c.getIngredientId().equals(i.getId())) {
                    Recipe recipe = getRecipeById(c.getRecipeId());
                    if (!recipes.contains(recipe)){
                        recipes.add(recipe);
                    }
                }
            }
        }
        return recipes;
    }

    //Searches for Recipes by multiple Ingredients and Tags.
    public List<Recipe> getRecipesByIngredients(List<Ingredient> ingredients,
                                                List<Tag> tags) {
        List<Recipe> recipes = new ArrayList<>();
        List<RecipeIngredientCombination> recipeIngredients = getAllRecipeIngredientCombinations();
        List<RecipeTagCombination> recipeTags = getAllRecipeTagCombinations();
        for (RecipeIngredientCombination c:recipeIngredients){
            for (Ingredient i:ingredients){
                if (c.getIngredientId().equals(i.getId())) {
                    Recipe recipe = getRecipeById(c.getRecipeId());
                    if (!recipes.contains(recipe)){
                        recipes.add(recipe);
                    }
                }
            }
        }
        for (RecipeTagCombination c:recipeTags) {
            for (Tag t:tags){
                if (c.getTagId().equals(t.getId())) {
                    Recipe recipe = getRecipeById(c.getRecipeId());
                    if (!recipes.contains(recipe)){
                        recipes.add(recipe);
                    }
                }
            }
        }
        return recipes;
    }

    //Add new Recipe to database
    public void addRecipe(String recipeName, int recipeDuration, String recipeDescription) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeName);
        recipe.setRecipeDuration(recipeDuration);
        recipe.setRecipeDescription(recipeDescription);
        Recipe newRecipe = this.recipeRepository.save(recipe);
        this.lastId = newRecipe.getId();
        System.out.println(this.lastId);
    }

    public long getLastId() {
        return this.lastId;
    }

    //Connect Tags to new recipe
    public void addRecipeTags(long recipeId, List<Long> tags) {
        for(Long t: tags){
            RecipeTagCombination combination = new RecipeTagCombination(recipeId, t);
            recipeTagRepository.save(combination);
        }
    }

    //Connect Ingredients to new recipe
    public void addRecipeIngredients(long recipeId, List<Long> ingredients) {
        for(Long i: ingredients){
            RecipeIngredientCombination combination = new RecipeIngredientCombination(recipeId, i);
            recipeIngredientRepository.save(combination);
        }
    }
}