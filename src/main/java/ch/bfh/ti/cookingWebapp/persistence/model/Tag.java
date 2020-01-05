package ch.bfh.ti.cookingWebapp.persistence.model;

import javax.persistence.*;

@Entity
@Table(name="tag")
@SequenceGenerator(name="tagSeq", initialValue = 50, allocationSize = 100)
public class Tag {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tagSeq")
    private long id;

    @Column(name="tag_name")
    private String tagName;

    @Column(name="tag_type")
    @GeneratedValue
    private long tagType;

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
        return tagType;
    }

    public void setType(long tag_type) {
        this.tagType = tag_type;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
