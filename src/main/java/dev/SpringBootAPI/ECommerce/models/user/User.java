package dev.SpringBootAPI.ECommerce.models.user;

import dev.SpringBootAPI.ECommerce.validators.ValidCpf;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = "password")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users") // Define o nome da tabela como "Users" no banco de dados.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera IDs automaticamente com base no banco de dados.
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "O email não pode ser nulo.")
    @Email(message = "O email deve ser válido.") // Validação de formato de email.
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @NotNull(message = "A senha não pode ser nula.")
    private String password;

    @NotNull(message = "O CPF não pode ser nulo.")
    @Column(unique = true)
    @ValidCpf(message = "CPF inválido.")// Validação de formato de email.
    private String cpf;

    @NotNull(message = "A data de nascimento não pode ser nula.")
    @Past(message = "A data de nascimento deve ser uma data passada.")
    private LocalDate birthDate;

    @NotNull(message = "O telefone não pode ser nulo.")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve ter o formato (XX) XXXX-XXXX ou (XX) XXXXX-XXXX.")
    private String phone;

    @OneToMany(mappedBy = "user")
    private List<Address> address;

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private UserType userType;

    private Boolean active = true;

    @NotNull(message = "A data de criação não pode ser nula.")
    @PastOrPresent(message = "A data de criação deve ser no passado ou presente.")
    private LocalDate createdAt;

    @PastOrPresent(message = "A data de atualização deve ser no passado ou presente.")
    private LocalDate updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}
