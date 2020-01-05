package ch.bfh.ti.cookingWebapp.persistence.service;

import ch.bfh.ti.cookingWebapp.persistence.model.Ingredient;
import ch.bfh.ti.cookingWebapp.persistence.model.Recipe;
import ch.bfh.ti.cookingWebapp.persistence.model.Tag;
import ch.bfh.ti.cookingWebapp.persistence.model.Unit;
import ch.bfh.ti.cookingWebapp.persistence.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServices {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServices(IngredientRepository ingredientRepository) {
        super();
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient getIngredientByName(String ingredientName) {
        List<Ingredient> ingredients = getAllIngredients();
        for (Ingredient i: ingredients){
            if (i.getIngredientName().equals(ingredientName)) {
                return i;
            }
        }
        return null;
    }

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        this.ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients;
    }

    public void addIngredient(String ingredientName, long unit) {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientName);
        ingredient.setIngredientUnit(unit);
        this.ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientById(Long ingredientId){
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        return ingredient.orElse(null);
    }
}
