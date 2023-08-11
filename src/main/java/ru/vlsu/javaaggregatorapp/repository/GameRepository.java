package ru.vlsu.javaaggregatorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.javaaggregatorapp.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {


}
