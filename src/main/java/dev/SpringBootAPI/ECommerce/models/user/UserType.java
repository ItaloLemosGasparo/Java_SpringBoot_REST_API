package dev.SpringBootAPI.ECommerce.models.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.management.ConstructorParameters;
import java.beans.ConstructorProperties;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserTypes")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "A descrição não pode ser nula.")
    @Size(min = 3, max = 255, message = "A descrição deve ter entre 3 e 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String description;

    @OneToMany(mappedBy = "userType")
    private List<User> user;

    public UserType(Integer id) {
        this.id = id;
    }
}
