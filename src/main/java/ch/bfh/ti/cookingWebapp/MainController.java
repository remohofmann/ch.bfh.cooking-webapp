package ch.bfh.ti.cookingWebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/main_page")
    public String mainPage() {
        return "main_page";
    }

    @RequestMapping("/userlogin")
    public String userlogin() { return "login"; }

    @RequestMapping("/signup")
    public String signup() { return "signup"; }

    @RequestMapping("/searchRecipes")
    public String searchRecipes() {return "searchRecipes"; }
}