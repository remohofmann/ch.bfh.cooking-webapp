package ch.bfh.ti.cookingWebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private RecipeServices recipeServices;

    @Autowired
    public ApiController(RecipeServices recipeServices){
        super();
        this.recipeServices = recipeServices;
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes(){
        return this.recipeServices.getAllRecipes();
    }

    @GetMapping("/mainPage")
    public String mainPage() {
        return "mainPage";
    }
}
