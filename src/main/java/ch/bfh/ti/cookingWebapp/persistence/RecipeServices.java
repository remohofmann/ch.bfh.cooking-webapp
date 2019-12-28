package ch.bfh.ti.cookingWebapp.persistence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServices {
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServices(RecipeRepository recipeRepository){
        super();
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes(){
        List<Recipe> recipes = new ArrayList<>();
        this.recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    //Searches for Recipes by tag.
    public List<Recipe> getRecipeByTag(String tag){
        List<Recipe> allRecipes = getAllRecipes();
        List<Recipe> recipes = new ArrayList<>();
        for (Recipe r:allRecipes){
            System.out.println(r.getRecipeTag());
            if (r.getRecipeTag().equals(tag)){
                recipes.add(r);
            }
        }
        return recipes;
    }
}