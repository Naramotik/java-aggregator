package ru.vlsu.javaaggregatorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vlsu.javaaggregatorapp.models.Link;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    @Query("from Link where game.id = :gameId")
    List<Link> findAllByGame_Id(@Param("gameId") Long gameId);
}
