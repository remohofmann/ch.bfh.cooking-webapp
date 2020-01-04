package ch.bfh.ti.cookingWebapp.persistence.validator;

import ch.bfh.ti.cookingWebapp.persistence.model.Ingredient;
import ch.bfh.ti.cookingWebapp.persistence.model.Tag;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class RecipeDto {

    @NotEmpty
    String nameInput;

    @NotEmpty
    int durationInput;

    @NotEmpty
    String recipeDescription;

    @NotEmpty
    List<Ingredient> ingredients;

    @NotEmpty
    List<Tag> tags;

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public int getDurationInput() {
        return durationInput;
    }

    public void setDurationInput(int durationInput) {
        this.durationInput = durationInput;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
