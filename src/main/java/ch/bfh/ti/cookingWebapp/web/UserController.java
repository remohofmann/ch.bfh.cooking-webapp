package ch.bfh.ti.cookingWebapp.web;

import ch.bfh.ti.cookingWebapp.auth.validator.UserRegistrationDto;
import ch.bfh.ti.cookingWebapp.persistence.model.Ingredient;
import ch.bfh.ti.cookingWebapp.persistence.model.TagType;
import ch.bfh.ti.cookingWebapp.persistence.service.IngredientServices;
import ch.bfh.ti.cookingWebapp.persistence.service.RecipeServices;
import ch.bfh.ti.cookingWebapp.persistence.service.TagServices;
import ch.bfh.ti.cookingWebapp.persistence.validator.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private RecipeServices recipeServices;
    private IngredientServices ingredientServices;
    private TagServices tagServices;

    @Autowired
    public UserController(RecipeServices recipeServices,
                           IngredientServices ingredientServices,
                           TagServices tagServices){
        super();
        this.recipeServices = recipeServices;
        this.ingredientServices = ingredientServices;
        this.tagServices = tagServices;
    }

    @GetMapping("/addNewRecipe")
    public String getAddNewRecipe(Model model){
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("tagDiet", this.tagServices.getTagsByType(TagType.DIET));
        model.addAttribute("tagCuisine", this.tagServices.getTagsByType(TagType.CUISINE));
        model.addAttribute("tagCourse", this.tagServices.getTagsByType(TagType.COURSE));
        model.addAttribute("ingredients", this.ingredientServices.getAllIngredients());
        model.addAttribute("newRecipe", new RecipeDto());
        return "addNewRecipe";
    }

    @PostMapping("/addNewIngredient")
    public String postAddNewIngredient(@RequestParam(value = "newIngredientInput") String ingredientInput,
                                       Model model) {
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("tagDiet", this.tagServices.getTagsByType(TagType.DIET));
        model.addAttribute("tagCuisine", this.tagServices.getTagsByType(TagType.CUISINE));
        model.addAttribute("tagCourse", this.tagServices.getTagsByType(TagType.COURSE));

        if (!ingredientInput.equals("")) {
            if (this.ingredientServices.getIngredientByName(ingredientInput) == null) {
                this.ingredientServices.addIngredient(ingredientInput, 1);
            }
        }
        model.addAttribute("ingredients", this.ingredientServices.getAllIngredients());

        return "addNewRecipe";
    }

    @PostMapping("/addNewRecipe")
    public String postAddNewRecipe(@ModelAttribute("newRecipe") @Valid RecipeDto recipeDto,
                                   BindingResult bindingResult,
                                   Model model) {
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("tagDiet", this.tagServices.getTagsByType(TagType.DIET));
        model.addAttribute("tagCuisine", this.tagServices.getTagsByType(TagType.CUISINE));
        model.addAttribute("tagCourse", this.tagServices.getTagsByType(TagType.COURSE));

        if (bindingResult.hasErrors()){
            return "addNewRecipe";
        }

        this.recipeServices.addRecipe(recipeDto.getNameInput(),
                recipeDto.getDurationInput(),
                recipeDto.getRecipeDescription());
        long id = this.recipeServices.getLastId();
        this.recipeServices.addRecipeTags(id, recipeDto.getTags());
        this.recipeServices.addRecipeIngredients(id, recipeDto.getIngredients());

        return "redirect:addNewRecipe?success";
    }
}
