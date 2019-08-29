package com.juk.menu.controller;

import com.juk.menu.model.Roll;
import com.juk.menu.repository.RollRepository;
import com.juk.menu.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MainController {
    private final RollRepository rollRepository;

    public MainController(RollRepository rollRepository) {
        this.rollRepository = rollRepository;
    }

    @GetMapping({"/", "welcome"})
    public String welcomePage(Model model) {
        model.addAttribute( "title", "Welcome" );
        model.addAttribute( "message", "Welcome to our service  - \"Menu of rolls\"" );
        return "welcomePage";
    }

    @GetMapping("/sign_in")
    public String signInPage(Model model) {
        return "sign_inPage";
    }

    @GetMapping("/sign_out")
    public String signOutPage(Model model) {
        model.addAttribute( "title", "Sign out" );
        return "sign_outPage";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString( loginedUser );

            model.addAttribute( "userInfo", userInfo );

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute( "message", message );

        }

        return "403Page";
    }

    @GetMapping("/add_user")
    public String addUserPage(Model model) {
        return "add_userPage";
    }

    @GetMapping("/menu")
    public String menuPage(Model model) {
        model.addAttribute( "rolls", rollRepository.findAll() );
        return "menuPage";
    }

    @GetMapping("/new_roll")
    public String showRollForm(Model model) {
        model.addAttribute( "rollAdd", new Roll() );
        return "add_rollPage";
    }

    @PostMapping("/add_roll")
    public String addRoll(@Valid Roll roll, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add_rollPage";
        }
        rollRepository.save( roll );
        Iterable<Roll> rolls = rollRepository.findAll();
        model.addAttribute( "rolls",rolls );
        return "menuPage";
    }
}

