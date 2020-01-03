package ch.bfh.ti.cookingWebapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/main_page")
    public String mainPage(Model model) {
        return "main_page";
    }

    @RequestMapping("/searchRecipes")
    public String searchRecipes(Model model) {return "searchRecipes"; }

    @RequestMapping("/compareRecipes")
    public String compareRecipes(Model model) {return "compareRecipes"; }

    @RequestMapping("/locale")
    public String locale(Model model) {return "locale"; }

}