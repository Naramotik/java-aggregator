package ru.vlsu.javaaggregatorapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vlsu.javaaggregatorapp.exception.RoleNotFoundException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRolesDTO {
    private ClientDTO clientDTO;
    private RolesDTO rolesDTO;
}
