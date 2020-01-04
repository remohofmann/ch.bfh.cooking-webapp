package ch.bfh.ti.cookingWebapp;

import ch.bfh.ti.cookingWebapp.persistence.model.TagType;
import ch.bfh.ti.cookingWebapp.persistence.service.IngredientServices;
import ch.bfh.ti.cookingWebapp.persistence.service.RecipeServices;
import ch.bfh.ti.cookingWebapp.persistence.model.Tag;
import ch.bfh.ti.cookingWebapp.persistence.service.TagServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* USAGE:
//    @GetMapping("/searchRecipes") // has to be like url
//    public String getRiceRecipes(Model model){
//        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(new Tag("Reis")));
//        return "searchRecipes"; // has to be like html
//    }
 */

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeServices recipeServices;
    private IngredientServices ingredientServices;
    private TagServices tagServices;

    @Autowired
    public RecipeController(RecipeServices recipeServices,
                            IngredientServices ingredientServices,
                            TagServices tagServices){
        super();
        this.recipeServices = recipeServices;
        this.ingredientServices = ingredientServices;
        this.tagServices = tagServices;
    }

    @GetMapping("/all")
    public String getAllRecipes(Model model){
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        return "recipes";
    }

    @GetMapping("/rice")
    public String getRecipeByTag(Model model){
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(new Tag("Reis")));
        return "recipes";
    }


    @GetMapping("/searchRecipes")
    public String getSearchRecipes(Model model){
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("tagDiet", this.tagServices.getTagsByType(TagType.DIET));
        model.addAttribute("tagCuisine", this.tagServices.getTagsByType(TagType.CUISINE));
        model.addAttribute("tagCourse", this.tagServices.getTagsByType(TagType.COURSE));
//        System.out.println(this.tagServices.getTagsByType(TagType.COURSE));
//        for (Tag t : this.tagServices.getAllTags()) {
//            System.out.println(t.getType());
//        }
        model.addAttribute("ingredients", this.ingredientServices.getAllIngredients());
        return "searchRecipes";
    }

    @GetMapping("/compareRecipes")
    public String getCompareRecipes(Model model){
        model.addAttribute("recipes", this.recipeServices.getFirstThreeRecipes());
        return "compareRecipes";
    }

    @GetMapping("/singleRecipe")
    public String getSingleRecipe(Model model){
        model.addAttribute("recipe", this.recipeServices.getSingleRecipe());
        return "singleRecipe";
    }

    @PostMapping("/singleRecipe")
    public String postSingleRecipe(@RequestParam(value = "recipeId") Long id,
                                   Model model){
        model.addAttribute("recipe", this.recipeServices.getRecipeById(id));
        model.addAttribute("ingredients", this.recipeServices.getIngredientsForRecipeId(id));
        model.addAttribute("tags", this.recipeServices.getTagsForRecipeId(id));
        return "singleRecipe";
    }

    @GetMapping("/adminArea")
    public String adminArea(Model model){
        model.addAttribute("recipe", this.recipeServices.getAllRecipes());
        return "recipes";
    }

}