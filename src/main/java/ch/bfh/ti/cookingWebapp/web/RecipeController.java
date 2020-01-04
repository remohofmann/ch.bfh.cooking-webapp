package ch.bfh.ti.cookingWebapp.web;

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

    @GetMapping("/searchRecipes")
    public String getSearchRecipes(Model model){
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/addNewRecipe")
    public String getAddNewRecipe(Model model){
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("tagDiet", this.tagServices.getTagsByType(TagType.DIET));
        model.addAttribute("tagCuisine", this.tagServices.getTagsByType(TagType.CUISINE));
        model.addAttribute("tagCourse", this.tagServices.getTagsByType(TagType.COURSE));
//        System.out.println(this.tagServices.getTagsByType(TagType.COURSE));
//        for (Tag t : this.tagServices.getAllTags()) {
//            System.out.println(t.getType());
//        }
        model.addAttribute("ingredients", this.ingredientServices.getAllIngredients());
        return "addNewRecipe";
    }


    @GetMapping("/compareRecipes")
    public String getCompareRecipes(Model model){
        model.addAttribute("recipes", this.recipeServices.getFirstThreeRecipes());
        return "compareRecipes";
    }

//    @GetMapping("/singleRecipe")
//    public String getSingleRecipe(Model model){
//        model.addAttribute("recipe", this.recipeServices.getSingleRecipe());
//        return "singleRecipe";
//    }

    @PostMapping("/singleRecipe")
    public String postSingleRecipe(@RequestParam(value = "recipeId") Long id,
                                   Model model){
        model.addAttribute("recipe", this.recipeServices.getRecipeById(id));
        model.addAttribute("ingredients", this.recipeServices.getIngredientsForRecipeId(id));
        model.addAttribute("tags", this.recipeServices.getTagsForRecipeId(id));
        return "singleRecipe";
    }

    @GetMapping("/glutenFree")
    public String getGlutenFreeRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Gluten free");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/vegetarian")
    public String getVegetarianRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Vegetarian");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/paleo")
    public String getPaleoRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Paleo");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/vegan")
    public String getVeganRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Vegan");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/breakfast")
    public String getBreakfastRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Breakfast");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/lunch")
    public String getLunchRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Lunch");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/dinner")
    public String getDinnerRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Dinner");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/indian")
    public String getIndianRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Indian");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/swiss")
    public String getSwissRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Swiss");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    @GetMapping("/chinese")
    public String getChineseRecipes(Model model){
        Tag tag = this.tagServices.getTagByName("Chinese");
        model.addAttribute("recipes", this.recipeServices.getRecipesByTag(tag));
        model = addSearchRecipeAttributes(model);
        return "searchRecipes";
    }

    public Model addSearchRecipeAttributes(Model model){
        model.addAttribute("tagDiet", this.tagServices.getTagsByType(TagType.DIET));
        model.addAttribute("tagCuisine", this.tagServices.getTagsByType(TagType.CUISINE));
        model.addAttribute("tagCourse", this.tagServices.getTagsByType(TagType.COURSE));
        model.addAttribute("ingredients", this.ingredientServices.getAllIngredients());
        return model;
    }

}