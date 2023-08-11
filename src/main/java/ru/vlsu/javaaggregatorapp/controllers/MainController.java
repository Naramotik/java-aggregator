package ru.vlsu.javaaggregatorapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.javaaggregatorapp.models.Client;
import ru.vlsu.javaaggregatorapp.models.Inputs;
import ru.vlsu.javaaggregatorapp.security.ClientDetails;
import ru.vlsu.javaaggregatorapp.service.ClientService;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class MainController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String helloPage(Model model){
        model.addAttribute("inputs", new Inputs());
        return "index";
    }


}
