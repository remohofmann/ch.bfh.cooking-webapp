package ch.bfh.ti.cookingWebapp.persistence.service;

import ch.bfh.ti.cookingWebapp.persistence.model.Ingredient;
import ch.bfh.ti.cookingWebapp.persistence.model.Recipe;
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

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        this.ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients;
    }

    public void addIngredient(String ingredientName, Unit unit) {
        Ingredient ingredient = new Ingredient(ingredientName, unit);
        this.ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientById(Long ingredientId){
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        return ingredient.orElse(null);
    }
}
