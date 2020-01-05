package ch.bfh.ti.cookingWebapp.web;

import ch.bfh.ti.cookingWebapp.auth.model.User;
import ch.bfh.ti.cookingWebapp.auth.service.SecurityService;
import ch.bfh.ti.cookingWebapp.auth.service.UserService;
import ch.bfh.ti.cookingWebapp.auth.validator.UserLoginDto;
import ch.bfh.ti.cookingWebapp.auth.validator.UserRegistrationDto;
import ch.bfh.ti.cookingWebapp.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new UserRegistrationDto());

        return "signup";
    }

    @PostMapping("/signup")
    public String registration(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult bindingResult) {

        User existing = userService.findByUsername(userDto.getUserName());
        if (existing != null){
            bindingResult.rejectValue("userName", null, "There is already an account registered with that username.");
        }

        if (bindingResult.hasErrors()){
            return "signup";
        }

        userService.save(userDto);

        securityService.autoLogin(userDto.getUserName(), userDto.getPassword());

        return "redirect:signup?success";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

//    # Only used when a redirect after login has to happen.
//    @PostMapping("/login")
//    public String login(@ModelAttribute("login") @Valid UserLoginDto loginDto,
//                        BindingResult bindingResult,
//                        String logout) {
//        if ((userService.findByUsername(loginDto.getUserNameOrMail()) == null) && ) {
//
//        }
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "redirect:admin";
//    }

    @GetMapping({"/welcome"})
    public String welcome(Model model) {
        return "main_page";
    }
}
