package ch.bfh.ti.cookingWebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService){
        super();
        this.recipeService = recipeService;
    }

    @GetMapping
    public String getAllRecipes(Model model){
        model.addAttribute("recipes", this.recipeService.getAllRecipes());
        return "recipes";
    }
}