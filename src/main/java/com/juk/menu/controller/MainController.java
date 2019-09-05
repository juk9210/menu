package com.juk.menu.controller;

import com.juk.menu.model.Roll;
import com.juk.menu.repository.SetRepository;
import com.juk.menu.repository.RollRepository;
import com.juk.menu.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.Transient;
import java.security.Principal;

/**
 * Создаём класс-контроллер,в котором будем
 * @author Shakhov Yevhen
 */

@Controller
public class MainController {
    private final RollRepository rollRepository;
    private final SetRepository setRepository;

    public MainController(RollRepository rollRepository, SetRepository setRepository) {
        this.rollRepository = rollRepository;
        this.setRepository = setRepository;
    }

    @GetMapping({"/", "welcome"})
    public String welcomePage(Model model) {
        model.addAttribute( "title", "Welcome" );
        model.addAttribute( "message", "Welcome to \"Banzai\".\n" +
                "Orders are accapted from 10 a.m. to 10 p.m.\n" +
                "Delivery is carried out within 1 hour from the time of  order. \n" +
                "Is your birthday today? Get a 20% discount on your birthday" );
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
    public String showSignForm(Model model) {
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
        model.addAttribute( "rolls", rolls );
        return "menuPage";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Roll roll = rollRepository.findById( id )
                .orElseThrow( () -> new IllegalArgumentException( "Invalid client Id:" + id ) );
        model.addAttribute( "roll", roll );
        return "update_rollPage";
    }

    @PostMapping("/update/{id}")
    public String updateRoll(@PathVariable("id") long id, @Valid Roll roll, BindingResult result, Model model) {
        if (result.hasErrors()) {
            roll.setId( id );
            return "update_rollPage";
        }
        rollRepository.save( roll );
        model.addAttribute( "rolls", rollRepository.findAll() );
        return "menuPage";
    }

    @Transient
    @GetMapping("/delete/{id}")
    public String deleteRoll(@PathVariable("id") long id, Model model) {
        rollRepository.deleteById( id );
        model.addAttribute( "rolls", rollRepository.findAll() );
        return "menuPage";
    }

    @GetMapping("/menu/sort/by_weight/up")
    public String sortByWeightUpPage(Model model) {
        model.addAttribute( "rolls", rollRepository.findByOrderByWeightAsc() );
        return "menuPage";
    }

    @GetMapping("/menu/sort/by_weight/down")
    public String sortByWeightDownPage(Model model) {
        model.addAttribute( "rolls", rollRepository.findByOrderByWeightDesc() );
        return "menuPage";
    }

    @GetMapping("/menu/sort/by_price/up")
    public String sortByPriceUpPage(Model model) {
        model.addAttribute( "rolls", rollRepository.findByOrderByPriceAsc() );
        return "menuPage";
    }

    @GetMapping("/menu/sort/by_price/down")
    public String sortByPriceDownPage(Model model) {
        model.addAttribute( "rolls", rollRepository.findByOrderByPriceDesc() );
        return "menuPage";
    }

    @GetMapping("/menu/find/by_type")
    public String sortByTypePage(@RequestParam(value = "search", required = true) String query, Model model) {
        model.addAttribute( "rolls", rollRepository.findByTypeOfRoll( query ) );
        return "menuPage";
    }
}

