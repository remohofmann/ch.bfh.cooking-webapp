package ch.bfh.ti.cookingWebapp.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    @Column(name="ingredient_name")
    private String ingredientName;

    @Column(name="ingredient_unit_id")
    private long ingredientUnit;

    public Ingredient() {
        super();
    }

    public Ingredient(String ingredientName, Unit ingredientUnit) {
        super();
        this.ingredientName = ingredientName;
        this.ingredientUnit = ingredientUnit.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public long getIngredientUnit() {
        return ingredientUnit;
    }

    public void setIngredientUnit(long ingredientUnit) {
        this.ingredientUnit = ingredientUnit;
    }
}
