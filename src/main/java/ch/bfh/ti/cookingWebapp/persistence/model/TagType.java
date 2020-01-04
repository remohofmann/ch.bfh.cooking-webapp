package ch.bfh.ti.cookingWebapp.persistence.model;

public enum TagType {
    CUISINE("cuisine", new Long(0)),
    DIET("diet", new Long(1)),
    COURSE("course", new Long(2));

    private String type;
    private Long tagNumber;

    TagType(String type, Long tagNumber) {
        this.type = type;
        this.tagNumber = tagNumber;
    }

    public String type() {
        return type;
    }

    public long tagNumber() {
        return tagNumber;
    }
}
