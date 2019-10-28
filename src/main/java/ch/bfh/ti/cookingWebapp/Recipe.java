package ch.bfh.ti.cookingWebapp;

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
    private String recipe_name;
    @Column(name="recipe_tag")
    private String recipe_tag;
    @Column(name="recipe_description")
    private String recipe_description;
    @Column(name="recipe_duration")
    private int recipe_duration;

    public Recipe() {
        super();
    }

    public Recipe(long id, String recipe_name, String recipe_tag, String recipe_description, int recipe_duration) {
        super();
        this.id = id;
        this.recipe_name = recipe_name;
        this.recipe_tag = recipe_tag;
        this.recipe_description = recipe_description;
        this.recipe_duration = recipe_duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getRecipe_tag() {
        return recipe_tag;
    }

    public void setRecipe_tag(String recipe_tag) {
        this.recipe_tag = recipe_tag;
    }

    public String getRecipe_description() {
        return recipe_description;
    }

    public void setRecipe_description(String recipe_description) {
        this.recipe_description = recipe_description;
    }

    public int getRecipe_duration() {
        return recipe_duration;
    }

    public void setRecipe_duration(int recipe_duration) {
        this.recipe_duration = recipe_duration;
    }
}

