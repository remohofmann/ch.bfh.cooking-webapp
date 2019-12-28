package ch.bfh.ti.cookingWebapp.persistence;

import javax.persistence.*;

@Entity
@Table(name="unit")
public class Unit {
    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    @Column(name="unitName")
    private String unitName;

    public Unit() {
        super();
    }

    public Unit(long id, String unitName) {
        super();
        this.id = id;
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
