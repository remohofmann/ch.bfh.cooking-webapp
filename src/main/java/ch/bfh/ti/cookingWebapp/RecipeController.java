package ch.bfh.ti.cookingWebapp;

import ch.bfh.ti.cookingWebapp.persistence.RecipeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeServices recipeServices;

    @Autowired
    public RecipeController(RecipeServices recipeServices){
        super();
        this.recipeServices = recipeServices;
    }

    @GetMapping("/all")
    public String getAllRecipes(Model model){
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        return "recipes";
    }

    @GetMapping("/rice")
    public String getRecipeByTag(Model model){
        model.addAttribute("recipes", this.recipeServices.getRecipeByTag("Reis"));
        return "recipes";
    }

    @GetMapping("/searchRecipes") // has to be like url
    public String getRiceRecipes(Model model){
        model.addAttribute("recipes", this.recipeServices.getRecipeByTag("Reis"));
        return "searchRecipes"; // has to be like html
    }
}