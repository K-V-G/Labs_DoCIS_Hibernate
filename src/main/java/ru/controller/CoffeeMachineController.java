package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.models.coffeeMachine;
import ru.service.coffeeMachineService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/coffeeMachine")
public class CoffeeMachineController {

    @Autowired
    private coffeeMachineService coffeeMachineService;

    @GetMapping()
    public String main(){
        return "main";
    }

    @GetMapping("/index")
    public String listCoffeeMachine(Model model) {
        List<coffeeMachine> coffeeMachineList = coffeeMachineService.findAll();
        model.addAttribute("coffeeMachine", coffeeMachineList);
        return "index";
    }
    @GetMapping("/indexRequest")
    public String listCoffeeMachineIndexRequest(Model model) {
        List<coffeeMachine> coffeeMachineList = coffeeMachineService.findAllReqest();
        model.addAttribute("coffeeMachine", coffeeMachineList);
        return "indexReqest";
    }

    @GetMapping("/index/{id}")
    public String showOneCoffeeMachine(@PathVariable("id") int id, Model model) {
        coffeeMachine coffeeMachine = coffeeMachineService.getCoffeeMachine(id);
        model.addAttribute("coffeeMachine", coffeeMachine);
        return "show";
    }


    @GetMapping("/new")
    public String saveCoffeeMachine(@ModelAttribute("coffeeMachine") coffeeMachine coffeeMachine){
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("coffeeMachine") @Valid coffeeMachine coffeeMachine,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        coffeeMachineService.saveCoffeeMachine(coffeeMachine);
        return "redirect:/coffeeMachine";
    }

    @GetMapping("/index/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        coffeeMachine coffeeMachine = coffeeMachineService.getCoffeeMachine(id);
        model.addAttribute("coffeeMachine", coffeeMachine);
        return "edit";
    }
    @RequestMapping(value = "/index/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("coffeeMachine") @Valid coffeeMachine coffeeMachine,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        coffeeMachineService.saveCoffeeMachine(coffeeMachine);
        return "redirect:/coffeeMachine";
    }

    @RequestMapping(value = "/index/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") int id) {
        coffeeMachineService.deleteCoffeeMachine(id);
        return "redirect:/coffeeMachine";
    }
}

