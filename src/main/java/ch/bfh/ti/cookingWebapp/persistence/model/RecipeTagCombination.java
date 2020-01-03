package ch.bfh.ti.cookingWebapp.persistence.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "recipe_tag")
public class RecipeTagCombination {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Long id;
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

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
