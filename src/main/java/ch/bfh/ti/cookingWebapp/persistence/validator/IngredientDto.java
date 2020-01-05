package ch.bfh.ti.cookingWebapp.persistence.validator;

import javax.validation.constraints.NotEmpty;

public class IngredientDto {

    @NotEmpty
    String ingredientName;

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
