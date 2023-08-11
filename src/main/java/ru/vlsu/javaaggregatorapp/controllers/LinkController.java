package ru.vlsu.javaaggregatorapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.javaaggregatorapp.dto.GameDTO;
import ru.vlsu.javaaggregatorapp.dto.GameLinkDTO;
import ru.vlsu.javaaggregatorapp.dto.LinkDTO;
import ru.vlsu.javaaggregatorapp.models.Game;
import ru.vlsu.javaaggregatorapp.models.Link;
import ru.vlsu.javaaggregatorapp.service.LinkService;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping()
    public ResponseEntity<LinkDTO> createLink(@RequestBody GameLinkDTO gameLinkDTO){                      //НЕ ПЕРЕДАВАТЬ LINK.ID
        ModelMapper modelMapper = new ModelMapper();
        LinkDTO linkDTO = gameLinkDTO.getLinkDTO().get(gameLinkDTO.getLinkDTO().size() - 1);
        GameDTO gameDTO = gameLinkDTO.getGameDTO();
        Link newLink = linkService.save(modelMapper.map(linkDTO, Link.class),
                                        modelMapper.map(gameDTO, Game.class));
        return new ResponseEntity<>(modelMapper.map(newLink, LinkDTO.class), HttpStatus.CREATED);
    }
    @PutMapping()   //TODO НЕ РАБОТАЕТ    НЕ РАБОТАЕТ      НЕ РАБОТАЕТ    НЕ РАБОТАЕТ   TODO НЕ РАБОТАЕТ
    public ResponseEntity<LinkDTO> updateLink(@RequestBody GameLinkDTO gameLinkDTO){
        ModelMapper modelMapper = new ModelMapper();
        LinkDTO linkDTO = gameLinkDTO.getLinkDTO().get(gameLinkDTO.getLinkDTO().size() - 1);
        GameDTO gameDTO = gameLinkDTO.getGameDTO();
        Link newLink = linkService.save(modelMapper.map(linkDTO, Link.class),
                                        modelMapper.map(gameDTO, Game.class));
        return new ResponseEntity<>(modelMapper.map(newLink, LinkDTO.class), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLink(@PathVariable("id") Long id){
        linkService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
