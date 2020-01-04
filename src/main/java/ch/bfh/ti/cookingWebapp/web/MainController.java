package ch.bfh.ti.cookingWebapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/main_page")
    public String mainPage(Model model) {
        return "main_page";
    }

    @RequestMapping("/")
    public String landingPage(Model model) {
        return "main_page";
    }

    @RequestMapping("/landingPage")
    public String landingPage2() {
        return"landingPage";
    }

    @RequestMapping("/searchRecipes")
    public String searchRecipes(Model model) {return "searchRecipes"; }

    @RequestMapping("/compareRecipes")
    public String compareRecipes(Model model) {return "compareRecipes"; }

    @RequestMapping("/locale")
    public String locale(Model model) {return "locale"; }


    @RequestMapping("/testsubPageFragments")
    public String testsubPageFragments(Model model) {return "testsubPageFragments"; }



}