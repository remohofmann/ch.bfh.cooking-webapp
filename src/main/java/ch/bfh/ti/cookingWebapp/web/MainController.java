package ch.bfh.ti.cookingWebapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class MainController {

    @RequestMapping("/main_page")
    public String mainPage(Model model) {
        return "landingPage";
    }

    @RequestMapping("/")
    public void downloadFiles(Model model,
                                HttpServletResponse response) {
        response.setContentType("application/zip");
        response.addHeader("Content-Disposition", "attachment; filename=assignment.zip");
        try {
            String dataDirectory = ("/static/");
            Path file = Paths.get(dataDirectory, "assignment.zip");
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping("/setLanguageDe")
    public String setLanguageDe(Model model) {
        return "redirect:landingPage?language=de";
    }

    @RequestMapping("/setLanguageFr")
    public String setLanguageFr(Model model) {
        return "redirect:landingPage?language=fr";
    }

    @RequestMapping("/setLanguageEn")
    public String setLanguageEn(Model model) {
        return "redirect:landingPage?language=en";
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

    @RequestMapping("/main_pageOld")
    public String mainPageOld(Model model) {return "main_pageOld"; }

    @RequestMapping("/termsAndConditions")
    public String termsAndConditions() {return "termsAndConditions"; }

}