package ch.bfh.ti.cookingWebapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServices
{
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServices(RecipeRepository recipeRepository){
        super();
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes(){
        List<Recipe> rooms = new ArrayList<>();
        this.recipeRepository.findAll().forEach(rooms::add);
        return rooms;
    }
}