package dev.SpringBootAPI.ECommerce.models.user;

import dev.SpringBootAPI.ECommerce.models.product.Product;
import dev.SpringBootAPI.ECommerce.validators.cpf.ValidCpf;
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
@Entity // Define a classe como uma entidade JPA
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users") // Define o nome da tabela no banco de dados
public class User {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome só pode conter letras e espaços.")
    @Column(nullable = false, length = 100) // Define as caracteristicas da coluna no banco
    private String name;

    @NotNull(message = "O email não pode ser nulo.")
    @Email(message = "O email deve ser válido.")
    @Size(max = 100, message = "O email deve ter no maximo 100 caracteres.")
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @NotNull(message = "A senha não pode ser nula.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}", message = "A senha deve ter no mínimo 8 caracteres, incluindo letras, números e caracteres especiais.")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "O CPF não pode ser nulo.")
    @ValidCpf(message = "CPF inválido.")
    @Column(unique = true, nullable = false)
    private String cpf;

    @NotNull(message = "A data de nascimento não pode ser nula.")
    @Past(message = "A data de nascimento deve ser uma data passada.")
    private LocalDate birthDate;

    // Definindo a chave estrangeira para o UserType
    @NotNull(message = "O tipo de usuário não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "userType_id", nullable = false)
    private UserType userType;

    private Boolean active = true;

    @NotNull(message = "A data de criação não pode ser nula.")
    @PastOrPresent(message = "A data de criação deve ser no passado ou presente.")
    private LocalDate createdAt;

    @PastOrPresent(message = "A data de atualização deve ser no passado ou presente.")
    private LocalDate updatedAt;

    //Referencias de outras tabelas para User
    @OneToMany(mappedBy = "user") // Define o relacionamento um-para-muitos com a entidade Address
    private List<Address> address;

    @OneToMany(mappedBy = "user") // Define o relacionamento um-para-muitos com a entidade Phone
    private List<Phone> phone;

    @OneToMany(mappedBy = "seller") // Define o relacionamento um-para-muitos com a entidade Product
    private List<Product> product;
    //

    @PrePersist // Metodo executado antes de persistir o usuário no banco de dados
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate // Metodo executado antes de atualizar o usuário no banco de dados
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}
