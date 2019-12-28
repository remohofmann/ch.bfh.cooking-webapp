package ch.bfh.ti.cookingWebapp.persistence;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Table;

@Repository
@Table(name = "recipe_tag")
public class RecipeTagCombination {

    @Column(name="recipe_id")
    private Long recipeId;
    @Column(name="tag_id")
    private Long tagId;

    public RecipeTagCombination(){super();}

    public RecipeTagCombination(Long recipeId, Long tagId){
        super();
        this.recipeId = recipeId;
        this.tagId = tagId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
