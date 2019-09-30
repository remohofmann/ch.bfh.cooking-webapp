package ch.bfh.ti.cookingWebapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private static List<Recipe> recipes = new ArrayList<>();

    static{
        for(int i=0;i<10;i++){
            recipes.add(new Recipe(i, "Recipe " + i, "R"+i, "Q"));
        }
    }

    public List<Recipe> getAllRecipes(){
        return recipes;
    }
}