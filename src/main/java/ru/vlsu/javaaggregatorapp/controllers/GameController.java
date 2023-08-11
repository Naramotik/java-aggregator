package ru.vlsu.javaaggregatorapp.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.javaaggregatorapp.dto.GameDTO;
import ru.vlsu.javaaggregatorapp.dto.GameLinkDTO;
import ru.vlsu.javaaggregatorapp.dto.LinkDTO;
import ru.vlsu.javaaggregatorapp.exception.GameNotFoundException;
import ru.vlsu.javaaggregatorapp.exception.LinkNotFoundException;
import ru.vlsu.javaaggregatorapp.models.Game;
import ru.vlsu.javaaggregatorapp.service.GameService;
import ru.vlsu.javaaggregatorapp.service.LinkService;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("games")
public class GameController {
    @Autowired
    GameService gameService;
    @Autowired
    LinkService linkService;
    @GetMapping                                                                                              //TODO ПАГИНАЦИЯ ПОИСК СОРТИРОВКА
    public ResponseEntity<List<GameDTO>> allGames() throws GameNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        List<GameDTO> gamesDTO = gameService.getAll()
                                    .stream()
                                    .map(game -> modelMapper.map(game, GameDTO.class))
                                    .collect(Collectors.toList());
        return new ResponseEntity<>(gamesDTO, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GameLinkDTO> detailGame(@PathVariable("id") Long id) throws GameNotFoundException, LinkNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        GameDTO gameDTO = modelMapper.map(gameService.detailGame(id), GameDTO.class);
        List<LinkDTO> linkDTO = linkService.gameLinks(id)
                            .stream()
                            .map(link -> modelMapper.map(link, LinkDTO.class))
                            .collect(Collectors.toList());
        return new ResponseEntity<>(new GameLinkDTO(gameDTO, linkDTO), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<GameDTO> createGame(@Valid @RequestBody GameDTO gameDTO){
        ModelMapper modelMapper = new ModelMapper();
        Game creatingGame = gameService.create(modelMapper.map(gameDTO, Game.class));
        return new ResponseEntity<>(modelMapper.map(creatingGame, GameDTO.class), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<GameDTO> updateGame(@RequestBody GameDTO gameDTO){
        ModelMapper modelMapper = new ModelMapper();
        Game creatingGame = gameService.create(modelMapper.map(gameDTO, Game.class));
        return new ResponseEntity<>(modelMapper.map(creatingGame, GameDTO.class), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Long id){
        gameService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
