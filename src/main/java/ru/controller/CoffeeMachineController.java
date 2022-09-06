package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
/*import ru.models.UserInfo;*/

import ru.models.coffeeMachine;
/*import ru.service.UserProfileService;
import ru.service.UserService;*/

import ru.service.coffeeMachineService;

/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

import javax.validation.Valid;
import java.util.List;

@SessionAttributes("roles")
@Controller
public class CoffeeMachineController {

    @Autowired
    private coffeeMachineService coffeeMachineService;
/*

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;
*/


    /*@Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @GetMapping("/login")
    public String welcomePage(){
        return "loginPage";
    }
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") UserInfo userInfo) {
        return "registrationPage";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Valid UserInfo user) {
        userService.saveUser(user);
        return "redirect:/login";
    }
*/

    @GetMapping("/coffeeMachine/mainPage")
    public String main() {
        return "main";
    }

    @GetMapping("/coffeeMachine/index")
    public String listCoffeeMachine(Model model) {
        List<coffeeMachine> coffeeMachineList = coffeeMachineService.findAll();
        model.addAttribute("coffeeMachine", coffeeMachineList);
        return "index";
    }

    @GetMapping("/coffeeMachine/indexRequest")
    public String listCoffeeMachineIndexRequest(Model model) {
        List<coffeeMachine> coffeeMachineList = coffeeMachineService.findAllReqest();
        model.addAttribute("coffeeMachine", coffeeMachineList);
        return "indexReqest";
    }

    @GetMapping("/coffeeMachine/index/{id}")
    public String showOneCoffeeMachine(@PathVariable("id") int id, Model model) {
        coffeeMachine coffeeMachine = coffeeMachineService.getCoffeeMachine(id);
        model.addAttribute("coffeeMachine", coffeeMachine);
        return "show";
    }

    @GetMapping("/coffeeMachine/new")
    public String saveCoffeeMachine(@ModelAttribute("coffeeMachine") coffeeMachine coffeeMachine) {
        return "new";
    }

    @RequestMapping(value = "/coffeeMachine/mainPage", method = RequestMethod.POST)
    public String create(@ModelAttribute("coffeeMachine") @Valid coffeeMachine coffeeMachine,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        coffeeMachineService.saveCoffeeMachine(coffeeMachine);
        return "redirect:/coffeeMachine/mainPage";
    }

    @GetMapping("/coffeeMachine/index/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        coffeeMachine coffeeMachine = coffeeMachineService.getCoffeeMachine(id);
        model.addAttribute("coffeeMachine", coffeeMachine);
        return "edit";
    }

    @RequestMapping(value = "/coffeeMachine/index/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("coffeeMachine") @Valid coffeeMachine coffeeMachine,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        coffeeMachineService.saveCoffeeMachine(coffeeMachine);
        return "redirect:/coffeeMachine/mainPage";
    }

    @RequestMapping(value = "/coffeeMachine/index/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") int id) {
        coffeeMachineService.deleteCoffeeMachine(id);
        return "redirect:/coffeeMachine/mainPage";
    }

    /*@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            persistentTokenBasedRememberMeServices.logout(request, response, authentication);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied() {
        return "accessDenied";
    }*/

}


