package ru.vlsu.javaaggregatorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vlsu.javaaggregatorapp.exception.LinkNotFoundException;
import ru.vlsu.javaaggregatorapp.models.Game;
import ru.vlsu.javaaggregatorapp.models.Link;
import ru.vlsu.javaaggregatorapp.repository.LinkRepository;

import java.util.List;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;

    public List<Link> gameLinks(Long game_id) throws LinkNotFoundException {
        if(linkRepository.findAllByGame_Id(game_id).isEmpty())
            throw new LinkNotFoundException("there is no links");
        else return linkRepository.findAllByGame_Id(game_id);
    }
    public Link save(Link link, Game game){
        link.setGame(game);
        return linkRepository.save(link);
    }
    public void delete(Long id){
        linkRepository.deleteById(id);
    }

}
