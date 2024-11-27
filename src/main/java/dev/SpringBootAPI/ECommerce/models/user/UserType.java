package dev.SpringBootAPI.ECommerce.models.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "UserTypes")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "A descrição não pode ser nula.")
    @Size(min = 100, max = 2000, message = "A descrição deve ter entre 100 e 2000 caracteres.")
    @Column(nullable = false, length = 2000)
    private String description;

    @OneToMany(mappedBy = "userType")
    private List<User> user;

    @PrePersist
    public void prePersist() {
        this.name = name.toUpperCase();
    }

    @PreUpdate
    public void preUpdate() {
        this.name = name.toUpperCase();
    }
}