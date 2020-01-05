package ch.bfh.ti.cookingWebapp.persistence.validator;

import ch.bfh.ti.cookingWebapp.persistence.model.Ingredient;
import ch.bfh.ti.cookingWebapp.persistence.model.Tag;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RecipeDto {

    @NotEmpty
    String nameInput;

    @NotNull
    int durationInput;

    @NotEmpty
    String recipeDescription;

    @NotEmpty
    List<Long> ingredients;

    @NotEmpty
    List<Long> dietTags;

    @NotEmpty
    List<Long> courseTags;

    @NotEmpty
    List<Long> cuisineTags;

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

    public List<Long> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Long> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Long> getDietTags() {
        return dietTags;
    }

    public void setDietTags(List<Long> dietTags) {
        this.dietTags = dietTags;
    }

    public List<Long> getCourseTags() {
        return courseTags;
    }

    public void setCourseTags(List<Long> courseTags) {
        this.courseTags = courseTags;
    }

    public List<Long> getCuisineTags() {
        return cuisineTags;
    }

    public void setCuisineTags(List<Long> cuisineTags) {
        this.cuisineTags = cuisineTags;
    }
}
