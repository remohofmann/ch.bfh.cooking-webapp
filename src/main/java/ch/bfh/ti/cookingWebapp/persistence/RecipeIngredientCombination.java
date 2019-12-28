package ch.bfh.ti.cookingWebapp.persistence;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Table;

@Repository
@Table(name = "recipe_ingredient")
public class RecipeIngredientCombination {

    @Column(name="recipe_id")
    private Long recipeId;
    @Column(name="ingredient_id")
    private Long ingredientId;

    public RecipeIngredientCombination(){super();}

    public RecipeIngredientCombination(Long recipeId, Long ingredientId){
        super();
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }
}
