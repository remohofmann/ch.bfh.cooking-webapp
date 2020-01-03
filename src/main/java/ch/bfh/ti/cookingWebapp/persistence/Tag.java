package ch.bfh.ti.cookingWebapp.persistence;

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

    @Column(name="tag_type")
    @GeneratedValue
    private long tag_type;

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

    public long getType() {
        return tag_type;
    }

    public void setType(long tag_type) {
        this.tag_type = tag_type;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
