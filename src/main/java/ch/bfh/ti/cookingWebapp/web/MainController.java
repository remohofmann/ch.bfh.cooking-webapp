package ch.bfh.ti.cookingWebapp.web;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
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
    @ResponseBody
    public ModelAndView getFile() {
        return new ModelAndView("redirect:https://1bbd085e69c44879b4aea5ce2016ffff.ds11s3ns.swisscom.com/ftp-transfer/submission.zip");
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