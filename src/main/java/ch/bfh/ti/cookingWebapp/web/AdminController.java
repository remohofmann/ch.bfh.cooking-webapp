package ch.bfh.ti.cookingWebapp.web;

import ch.bfh.ti.cookingWebapp.persistence.service.IngredientServices;
import ch.bfh.ti.cookingWebapp.persistence.service.RecipeServices;
import ch.bfh.ti.cookingWebapp.persistence.service.TagServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private RecipeServices recipeServices;
    private IngredientServices ingredientServices;
    private TagServices tagServices;

    @Autowired
    public AdminController(RecipeServices recipeServices,
                           IngredientServices ingredientServices,
                           TagServices tagServices){
        super();
        this.recipeServices = recipeServices;
        this.ingredientServices = ingredientServices;
        this.tagServices = tagServices;
    }

    @GetMapping("/adminArea")
    public String adminArea(Model model){
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        return "adminArea";
    }
}
