package ch.bfh.ti.cookingWebapp.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="tag")
public class Tag {
    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    @Column(name="tag_name")
    private String tagName;

    public Tag() {
        super();
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    //getters and setters:
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
