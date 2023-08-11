package ru.vlsu.javaaggregatorapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "game")
public class Game {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotNull(message = "Not empty!")
    private String title;

    @Column(name = "description")
    @NotNull(message = "Not empty!")
    private String description;

    @ManyToMany(mappedBy = "games",
                fetch = FetchType.EAGER,
                cascade = CascadeType.REMOVE)
    private List<WishList> wishLists;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    private List<Link> links;

}
