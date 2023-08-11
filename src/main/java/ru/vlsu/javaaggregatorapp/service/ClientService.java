package ru.vlsu.javaaggregatorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vlsu.javaaggregatorapp.dto.ClientDTO;
import ru.vlsu.javaaggregatorapp.exception.RoleNotFoundException;
import ru.vlsu.javaaggregatorapp.exception.UserAlreadyExistException;
import ru.vlsu.javaaggregatorapp.models.Client;
import ru.vlsu.javaaggregatorapp.models.Roles;
import ru.vlsu.javaaggregatorapp.repository.ClientRepository;
import ru.vlsu.javaaggregatorapp.repository.RolesRepository;

import java.util.LinkedList;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Client getById(Long id){
        if (clientRepository.findById(id).isPresent())
            return clientRepository.findById(id).get();
        else return null;
    }
    public Client save(Client client) throws UserAlreadyExistException {
        if (clientRepository.findByName(client.getName()).isPresent())
            throw new UserAlreadyExistException("name is exist already");
        else{
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            //TODO СОЗДАНИЕ WISHLIST
            Roles role = rolesRepository.findByTitle("ROLE_USER");
            client.setRole(role);
            clientRepository.save(client);
            return client;
        }
    }
    public Client setNewRole(Client client, Roles role) throws RoleNotFoundException {
        if (rolesRepository.findByTitle(role.getTitle()) != null){
            client.setRole(rolesRepository.findByTitle(role.getTitle()));
            return clientRepository.save(client);
        }
        else throw new RoleNotFoundException("role doesn't exist");
    }
    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
}
