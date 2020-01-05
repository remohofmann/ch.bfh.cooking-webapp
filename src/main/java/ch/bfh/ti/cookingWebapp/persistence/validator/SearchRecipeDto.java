package ch.bfh.ti.cookingWebapp.persistence.validator;

import java.util.ArrayList;
import java.util.List;

public class SearchRecipeDto {

    List<Long> searchCuisineTags;
    List<Long> searchDietTags;
    List<Long> searchCourseTags;
    List<Long> searchIngredients;

    public List<Long> getSearchCuisineTags() {
        return searchCuisineTags;
    }

    public void setSearchCuisineTags(List<Long> searchCuisineTags) {
        this.searchCuisineTags = searchCuisineTags;
    }

    public List<Long> getSearchDietTags() {
        return searchDietTags;
    }

    public void setSearchDietTags(List<Long> searchDietTags) {
        this.searchDietTags = searchDietTags;
    }

    public List<Long> getSearchCourseTags() {
        return searchCourseTags;
    }

    public void setSearchCourseTags(List<Long> searchCourseTags) {
        this.searchCourseTags = searchCourseTags;
    }

    public List<Long> getSearchIngredients() {
        return searchIngredients;
    }

    public void setSearchIngredients(List<Long> searchIngredients) {
        this.searchIngredients = searchIngredients;
    }
}
