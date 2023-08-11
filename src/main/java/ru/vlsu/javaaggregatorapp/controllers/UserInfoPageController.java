package ru.vlsu.javaaggregatorapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.javaaggregatorapp.security.ClientDetails;
import ru.vlsu.javaaggregatorapp.service.ClientService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserInfoPageController {
    @Autowired
    private ClientService clientService;


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
