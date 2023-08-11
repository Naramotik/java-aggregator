package ru.vlsu.javaaggregatorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlsu.javaaggregatorapp.models.Roles;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByTitle(String title);
}
