package ch.bfh.ti.cookingWebapp.web;

import ch.bfh.ti.cookingWebapp.auth.model.User;
import ch.bfh.ti.cookingWebapp.auth.service.SecurityService;
import ch.bfh.ti.cookingWebapp.auth.service.UserService;
import ch.bfh.ti.cookingWebapp.auth.validator.UserRegistrationDto;
import ch.bfh.ti.cookingWebapp.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/signup")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegistrationDto());

        return "signup";
    }

    @PostMapping("/signup")
    public String registration(@ModelAttribute("user") @Valid UserRegistrationDto user, BindingResult bindingResult) {

        User existing = userService.findByUsername(user.getUserName());
        if (existing != null){
            bindingResult.rejectValue("userName", null, "There is already an account registered with that username.");
        }

        if (bindingResult.hasErrors()){
            return "registration";
        }

        User newUser = new User();
        newUser.setUsername(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setMail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName((user.getLastName()));
        userService.save(newUser);

        securityService.autoLogin(user.getUserName(), user.getConfirmPassword());

        return "redirect:/signup?success";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
