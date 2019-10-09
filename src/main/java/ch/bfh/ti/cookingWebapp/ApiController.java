package ch.bfh.ti.cookingWebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private RecipeService recipeService;

    @Autowired
    public ApiController(RecipeService recipeService){
        super();
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes(){
        return this.recipeService.getAllRecipes();
    }

    @GetMapping("/mainPage")
    public String mainPage() {
        return "mainPage";
    }
}
