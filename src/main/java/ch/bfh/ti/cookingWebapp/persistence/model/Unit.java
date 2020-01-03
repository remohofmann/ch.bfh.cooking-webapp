package ch.bfh.ti.cookingWebapp.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="unit")
public class Unit {
    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    @Column(name="unit_name")
    private String unitName;

    public Unit() {
        super();
    }

    public Unit(String unitName) {
        super();
        this.unitName = unitName;
    }

    //getters and setters:
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
