package ru.vlsu.javaaggregatorapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "link")
public class Link {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_name")
    @NotNull(message = "Not empty!")
    private String shopName;

    @Column(name = "address")
    @NotNull(message = "Not empty!")
    private String address;

    @Column(name = "cost")
    @NotNull(message = "Not empty!")
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
