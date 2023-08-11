package ru.vlsu.javaaggregatorapp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class ClientDTO {
    private int id;
    @NotBlank(message = "name shouldn't be null")
    private String name;
    @NotBlank(message = "email shouldn't be null")
    private String email;
    @NotBlank(message = "password shouldn't be null")
    private String password;
}
