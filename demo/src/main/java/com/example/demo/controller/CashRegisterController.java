package com.example.demo.controller;


import com.example.demo.model.CashRegister;
import com.example.demo.service.CashRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CashRegisterController {

    @Autowired
    private CashRegisterService vartotojasService;

    //@RequestMapping(value = "/", method= RequestMethod.GET)
    @GetMapping("/vartotojas")
    public String getVartotojai(ModelMap model) {
        model.put("vartotojai", vartotojasService.findAll());
        return "vartotojas"; // view resolver /WEB-INF/jsp/welcome.jsp
    }

    @GetMapping("/add-vartotojas")
    public String showAddPage(ModelMap model) {
        model.addAttribute("vartotojas", new CashRegister());
        return "add-vartotojas";
    }

    @PostMapping("/add-vartotojas")
    public String add(ModelMap model, @ModelAttribute("vartotojas") CashRegister vartotojas, BindingResult result) {
        if (result.hasErrors()) {
            return "add-vartotojas";
        }
        vartotojasService.add(vartotojas);
        return "redirect:/vartotojas";
    }

    @GetMapping("/update-vartotojas/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable long id) {
        model.addAttribute("vartotojas", vartotojasService.findById(id));
        return "add-vartotojas";
    }

    @PostMapping("/update-vartotojas/{id}")
    public String update(ModelMap model, @ModelAttribute("vartotojas") CashRegister vartotojas, BindingResult result) {
        if (result.hasErrors()) {
            return "add-vartotojas";
        }
        vartotojasService.update(vartotojas);
        return "redirect:/vartotojas";
    }

    @GetMapping("/delete-vartotojas/{id}")
    public String delete(@PathVariable long id) {
        vartotojasService.deleteById(id);
        return "redirect:/vartotojas";
    }
}
