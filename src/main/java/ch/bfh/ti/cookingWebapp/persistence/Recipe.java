package ch.bfh.ti.cookingWebapp.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;
    @Column(name="recipe_name")
    private String recipeName;
    @Column(name="recipe_tag")
    private String recipeTag;
    @Column(name="recipe_description")
    private String recipeDescription;
    @Column(name="recipe_duration")
    private int recipeDuration;

    public Recipe() {
        super();
    }

    public Recipe(long id, String recipeName, String recipeTag, String recipeDescription, int recipeDuration) {
        super();
        this.id = id;
        this.recipeName = recipeName;
        this.recipeTag = recipeTag;
        this.recipeDescription = recipeDescription;
        this.recipeDuration = recipeDuration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipe_name) {
        this.recipeName = recipe_name;
    }

    public String getRecipeTag() {
        return recipeTag;
    }

    public void setRecipeTag(String recipe_tag) {
        this.recipeTag = recipe_tag;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipe_description) {
        this.recipeDescription = recipe_description;
    }

    public int getRecipeDuration() {
        return recipeDuration;
    }

    public void setRecipeDuration(int recipe_duration) {
        this.recipeDuration = recipe_duration;
    }
}

