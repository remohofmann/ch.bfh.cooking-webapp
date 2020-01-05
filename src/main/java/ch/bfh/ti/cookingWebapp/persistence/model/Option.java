package ch.bfh.ti.cookingWebapp.persistence.model;

public class Option {

    private long id;

    private String optionName;

    public Option(long id, String optionName) {
        this.id = id;
        this.optionName = optionName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
