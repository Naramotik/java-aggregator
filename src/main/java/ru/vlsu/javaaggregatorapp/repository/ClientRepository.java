package ru.vlsu.javaaggregatorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vlsu.javaaggregatorapp.models.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByName(String username);

//    @Modifying
//    @Query("update Client set role.id = :role where client.id = :clientId")
//    Client setNewRole(Long clientId, String role);
}
