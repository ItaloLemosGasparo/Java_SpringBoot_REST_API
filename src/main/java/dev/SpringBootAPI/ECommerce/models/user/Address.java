package dev.SpringBootAPI.ECommerce.models.user;

import dev.SpringBootAPI.ECommerce.validators.address.ValidZipcode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "UserAddresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O CEP não pode ser nulo.")
    @ValidZipcode(message = "O CEP deve estar no formato 00000-000.")
    @Column(nullable = false, length = 9)
    private String zipCode;

    @NotNull(message = "O logradouro não pode ser nulo.")
    @Size(min = 3, max = 255, message = "O logradouro deve ter entre 3 e 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String street;

    @Size(min = 3, max = 100, message = "O complemento deve ter entre 3 e 100 caracteres.")
    @Column(nullable = true, length = 100)
    private String complement;

    @NotNull(message = "O número não pode ser nulo.")
    @Size(max = 6, message = "O número deve ter no máximo 6 caracteres.")
    @Column(nullable = false, length = 6)
    private String number;

    @NotNull(message = "O bairro não pode ser nulo.")
    @Size(min = 3, max = 255, message = "O bairro deve ter entre 3 e 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String neighborhood;

    @NotNull(message = "A cidade não pode ser nula.")
    @Size(min = 3, max = 150, message = "A cidade deve ter entre 3 e 150 caracteres.")
    @Column(nullable = false, length = 150)
    private String city;

    @NotNull(message = "O estado/UF não pode ser nulo.")
    @Pattern(regexp = "^[A-Z]{2}$", message = "O estado/UF deve ser composta por duas letras maiúsculas.")
    @Column(nullable = false, length = 2)
    private String state;

    // Chave estrangeira para o id do User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
