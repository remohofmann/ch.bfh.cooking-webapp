package ch.bfh.ti.cookingWebapp.persistence;


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

    @Autowired
    public RecipeServices(RecipeRepository recipeRepository,
                          RecipeTagRepository recipeTagRepository,
                          RecipeIngredientRepository recipeIngredientRepository) {
        super();
        this.recipeRepository = recipeRepository;
        this.recipeTagRepository = recipeTagRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
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
}