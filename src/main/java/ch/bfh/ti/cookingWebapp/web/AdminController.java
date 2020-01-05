package ch.bfh.ti.cookingWebapp.web;

import ch.bfh.ti.cookingWebapp.auth.model.User;
import ch.bfh.ti.cookingWebapp.auth.service.UserServiceImpl;
import ch.bfh.ti.cookingWebapp.persistence.service.IngredientServices;
import ch.bfh.ti.cookingWebapp.persistence.service.RecipeServices;
import ch.bfh.ti.cookingWebapp.persistence.service.TagServices;
import ch.bfh.ti.cookingWebapp.persistence.validator.SearchRecipeDto;
import ch.bfh.ti.cookingWebapp.persistence.validator.TagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private RecipeServices recipeServices;
    private IngredientServices ingredientServices;
    private TagServices tagServices;
    private UserServiceImpl userService;

    @Autowired
    public AdminController(RecipeServices recipeServices,
                           IngredientServices ingredientServices,
                           TagServices tagServices,
                           UserServiceImpl userService){
        super();
        this.recipeServices = recipeServices;
        this.ingredientServices = ingredientServices;
        this.tagServices = tagServices;
        this.userService = userService;

    }

    @GetMapping("/adminArea")
    public String adminArea(Model model) {
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("users", this.userService.getAllUsers());
        model.addAttribute("options", this.tagServices.getOptionList());
        model.addAttribute("newTag", new TagDto());
        return "adminArea";
    }

    @PostMapping("/deleteRecipe")
    public String deleteRecipe(@RequestParam(value = "recipeId") Long recipeId,
                               Model model) {
        this.recipeServices.deleteRecipe(recipeId);
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("users", this.userService.getAllUsers());
        model.addAttribute("options", this.tagServices.getOptionList());
        model.addAttribute("newTag", new TagDto());

        return "redirect:adminArea?recipeDeleted";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "userId") Long userId,
                               Model model) {
        this.userService.deleteUser(userId);
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("users", this.userService.getAllUsers());
        model.addAttribute("options", this.tagServices.getOptionList());
        model.addAttribute("newTag", new TagDto());

        return "redirect:adminArea?userDeleted";
    }

    @PostMapping("/addTag")
    public String addTag(@ModelAttribute("newTag") @Valid TagDto tagDto,
                         Model model) {
        model.addAttribute("recipes", this.recipeServices.getAllRecipes());
        model.addAttribute("users", this.userService.getAllUsers());
        model.addAttribute("options", this.tagServices.getOptionList());
        if (tagDto.getTagName().equals("")) {
            model.addAttribute("newTag", new TagDto());
            return "redirect:adminArea?tagNotSaved";
        }
        if (this.tagServices.getTagByName(tagDto.getTagName()) != null) {
            model.addAttribute("newTag", new TagDto());
            return "redirect:adminArea?tagNotSaved";
        }
        this.tagServices.addTag(tagDto.getTagName(), tagDto.getTagType());
        model.addAttribute("newTag", new TagDto());
        return "redirect:adminArea?tagSaved";
    }
}
