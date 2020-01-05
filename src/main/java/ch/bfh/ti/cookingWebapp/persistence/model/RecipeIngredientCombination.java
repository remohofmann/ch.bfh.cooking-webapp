package ch.bfh.ti.cookingWebapp.persistence.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "recipe_ingredient")
@SequenceGenerator(name="recipeIngredientSeq", initialValue = 50, allocationSize = 100)
public class RecipeIngredientCombination {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeIngredientSeq")
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
