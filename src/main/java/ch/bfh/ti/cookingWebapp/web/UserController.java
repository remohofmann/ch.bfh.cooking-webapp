package ch.bfh.ti.cookingWebapp.web;

import ch.bfh.ti.cookingWebapp.persistence.model.Ingredient;
import ch.bfh.ti.cookingWebapp.persistence.model.TagType;
import ch.bfh.ti.cookingWebapp.persistence.service.IngredientServices;
import ch.bfh.ti.cookingWebapp.persistence.service.RecipeServices;
import ch.bfh.ti.cookingWebapp.persistence.service.TagServices;
import ch.bfh.ti.cookingWebapp.persistence.validator.IngredientDto;
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
        model.addAttribute("newIngredient", new IngredientDto());
        return "addNewRecipe";
    }

    @PostMapping("/addNewIngredient")
    public String postAddNewIngredient(@ModelAttribute("newIngredient") @Valid IngredientDto ingredientDto,
                                       BindingResult bindingResult,
                                       Model model) {
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("tagDiet", this.tagServices.getTagsByType(TagType.DIET));
        model.addAttribute("tagCuisine", this.tagServices.getTagsByType(TagType.CUISINE));
        model.addAttribute("tagCourse", this.tagServices.getTagsByType(TagType.COURSE));

        if (!ingredientDto.getIngredientName().equals("")) {
            if (this.ingredientServices.getIngredientByName(ingredientDto.getIngredientName()) == null) {
                this.ingredientServices.addIngredient(ingredientDto.getIngredientName(), 1);
            }
        }
        model.addAttribute("ingredients", this.ingredientServices.getAllIngredients());
        model.addAttribute("newIngredient", new IngredientDto());

        return "redirect:addNewRecipe?success";
    }

    @PostMapping("/addNewRecipe")
    public String postAddNewRecipe(@ModelAttribute("newRecipe") @Valid RecipeDto recipeDto,
                                   BindingResult bindingResult,
                                   Model model) {
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
        System.out.println(recipeDto.getIngredients());
        this.recipeServices.addRecipeTags(id, recipeDto.getCourseTags());
        this.recipeServices.addRecipeTags(id, recipeDto.getCuisineTags());
        this.recipeServices.addRecipeTags(id, recipeDto.getDietTags());
        this.recipeServices.addRecipeIngredients(id, recipeDto.getIngredients());

        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("newRecipe", new RecipeDto());

        return "redirect:addNewRecipe?success";
    }
}
