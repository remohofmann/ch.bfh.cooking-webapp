package ch.bfh.ti.cookingWebapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/main_page")
    public String mainPage() {
        return "main_page";
    }

    @RequestMapping("/searchRecipes")
    public String searchRecipes() {
        return "searchRecipes";
    }
}