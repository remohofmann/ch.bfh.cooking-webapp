package ch.bfh.ti.cookingWebapp.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="recipe")
@SequenceGenerator(name="recipeSeq", initialValue = 50, allocationSize = 1)
public class Recipe {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeSeq")
    private long id;
    @Column(name="recipe_name")
    private String recipeName;
    @Column(name="recipe_description")
    private String recipeDescription;
    @Column(name="recipe_duration")
    private int recipeDuration;

    public Recipe() {
        super();
    }

    public Recipe(String recipeName, String recipeDescription, int recipeDuration) {
        super();
        this.recipeName = recipeName;
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

