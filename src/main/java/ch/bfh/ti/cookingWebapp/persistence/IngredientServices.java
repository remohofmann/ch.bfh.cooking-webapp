package ch.bfh.ti.cookingWebapp.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
