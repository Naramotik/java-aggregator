package ru.vlsu.javaaggregatorapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)      // ПОИСК В БД ИДЕТ ПО ИМЕНИ, ПОЭТОМУ 2 ОДИНАКОВЫХ БЫТЬ НЕ ДОЛЖНО
    @NotNull(message = "Not empty!")
    private String name;

    @Email
    @NotNull(message = "Not empty!")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Not empty!")
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

    @JsonIgnore
    @OneToOne(mappedBy = "client", cascade = CascadeType.REMOVE)
    private WishList wishList;


    public String getRoles() {
        return role.toString();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + role +
                '}';
    }
}
