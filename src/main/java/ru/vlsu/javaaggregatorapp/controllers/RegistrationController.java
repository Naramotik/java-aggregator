package ru.vlsu.javaaggregatorapp.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.javaaggregatorapp.dto.ClientDTO;
import ru.vlsu.javaaggregatorapp.dto.ClientRolesDTO;
import ru.vlsu.javaaggregatorapp.dto.RolesDTO;
import ru.vlsu.javaaggregatorapp.exception.RoleNotFoundException;
import ru.vlsu.javaaggregatorapp.exception.UserAlreadyExistException;
import ru.vlsu.javaaggregatorapp.models.Client;
import ru.vlsu.javaaggregatorapp.models.Roles;
import ru.vlsu.javaaggregatorapp.security.ClientDetails;
import ru.vlsu.javaaggregatorapp.service.ClientService;

import java.util.Collection;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RegistrationController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/myRole")
    public Collection<? extends GrantedAuthority> whichRole(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        return authentication.getAuthorities();
    }
    @PostMapping("/login")
    public ResponseEntity<?> performLogin(@RequestBody ClientDTO clientDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(clientDTO.getName(), clientDTO.getPassword()));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PostMapping("/registration")
    public ResponseEntity<ClientDTO> registrationPOST(@Valid @RequestBody ClientDTO clientDTO) throws UserAlreadyExistException {
        ModelMapper modelMapper = new ModelMapper();
        Client newClient = clientService.save(modelMapper.map(clientDTO, Client.class));
        return new ResponseEntity<>(modelMapper.map(newClient, ClientDTO.class), HttpStatus.CREATED);
    }
    @PostMapping("/roles")
    public ResponseEntity<ClientDTO> setNewRole(@RequestBody ClientRolesDTO clientRolesDTO) throws UserAlreadyExistException, RoleNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        ClientDTO clientDTO = clientRolesDTO.getClientDTO();
        RolesDTO rolesDTO = clientRolesDTO.getRolesDTO();
        Client updatedClient = clientService.setNewRole(modelMapper.map(clientDTO, Client.class),
                                                        modelMapper.map(rolesDTO, Roles.class));
        return new ResponseEntity<>(modelMapper.map(updatedClient, ClientDTO.class), HttpStatus.CREATED);
    }
}

