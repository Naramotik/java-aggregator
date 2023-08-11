package ru.vlsu.javaaggregatorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.javaaggregatorapp.dto.GameDTO;
import ru.vlsu.javaaggregatorapp.exception.GameNotFoundException;
import ru.vlsu.javaaggregatorapp.models.Game;
import ru.vlsu.javaaggregatorapp.models.Link;
import ru.vlsu.javaaggregatorapp.repository.GameRepository;
import ru.vlsu.javaaggregatorapp.repository.LinkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll() throws GameNotFoundException {
        if (gameRepository.findAll().isEmpty())
            throw new GameNotFoundException("there is no games");
        else return gameRepository.findAll();
    }

    public Game detailGame(Long id) throws GameNotFoundException {
        return gameRepository.findById(id).orElseThrow(()->new GameNotFoundException("no game with id: " + id));
    }
    public Game create(Game game){
        return gameRepository.save(game);
    }
    public void delete(Long id){
        gameRepository.deleteById(id);
    }
}
