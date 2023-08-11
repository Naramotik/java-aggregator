package ru.vlsu.javaaggregatorapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private int id;
    @NotBlank(message = "title shouldn't be null")
    private String title;
    @NotBlank(message = "description shouldn't be null")
    private String description;
}
