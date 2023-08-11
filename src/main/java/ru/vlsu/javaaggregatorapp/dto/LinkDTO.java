package ru.vlsu.javaaggregatorapp.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTO {
    private int id;
    @NotBlank(message = "shopName shouldn't be null")
    private String shopName;
    @NotBlank(message = "address shouldn't be null")
    private String address;
    @NotNull(message = "cost shouldn't be null")
    private BigDecimal cost;
}
