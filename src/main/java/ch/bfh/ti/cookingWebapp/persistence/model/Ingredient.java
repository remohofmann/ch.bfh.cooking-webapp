package ch.bfh.ti.cookingWebapp.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="ingredient")
@SequenceGenerator(name="ingredientSeq", initialValue = 50, allocationSize = 1)
public class Ingredient {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredientSeq")
    private long id;

    @Column(name="ingredient_name")
    private String ingredientName;

    @Column(name="ingredient_unit_id")
    private long ingredientUnit;

    public Ingredient() {
        super();
    }

    public Ingredient(String ingredientName, long ingredientUnit) {
        super();
        this.ingredientName = ingredientName;
        this.ingredientUnit = ingredientUnit;
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
