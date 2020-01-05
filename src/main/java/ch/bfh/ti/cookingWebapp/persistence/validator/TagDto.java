package ch.bfh.ti.cookingWebapp.persistence.validator;

import javax.validation.constraints.NotNull;

public class TagDto {

    @NotNull
    private String tagName;

    @NotNull
    private long tagType;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public long getTagType() {
        return tagType;
    }

    public void setTagType(long tagType) {
        this.tagType = tagType;
    }
}
