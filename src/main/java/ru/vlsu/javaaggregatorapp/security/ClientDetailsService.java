package ru.vlsu.javaaggregatorapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vlsu.javaaggregatorapp.models.Client;
import ru.vlsu.javaaggregatorapp.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> student = repository.findByName(username);

        return student.map(ClientDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}
