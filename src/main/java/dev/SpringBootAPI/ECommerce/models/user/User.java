package dev.SpringBootAPI.ECommerce.models.user;

import dev.SpringBootAPI.ECommerce.models.product.Product;
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
@EqualsAndHashCode(exclude = "password") // Exclui o campo 'password' da comparação de igualdade e do cálculo do hashCode
@Entity // Define a classe como uma entidade JPA
@AllArgsConstructor // Gera um construtor com todos os campos da classe
@NoArgsConstructor // Gera um construtor sem parâmetros
@Table(name = "Users") // Define o nome da tabela no banco de dados
public class User {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração do ID como identidade (autoincremento)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100) // Define as caracteristicas da coluna no banco
    private String name;

    @NotNull(message = "O email não pode ser nulo.")
    @Email(message = "O email deve ser válido.")
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @NotNull(message = "A senha não pode ser nula.")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "O CPF não pode ser nulo.")
    @ValidCpf(message = "CPF inválido.")
    @Column(unique = true)
    private String cpf;

    @NotNull(message = "A data de nascimento não pode ser nula.")
    @Past(message = "A data de nascimento deve ser uma data passada.")
    private LocalDate birthDate;

    // Definindo a chave estrangeira para o UserType
    @ManyToOne // Define um relacionamento muitos-para-um com a entidade UserType
    @JoinColumn(name = "userType_id", nullable = false) // Especifica a coluna 'userType_id' como chave estrangeira
    private UserType userType;

    private Boolean active = true;

    @NotNull(message = "A data de criação não pode ser nula.")
    @PastOrPresent(message = "A data de criação deve ser no passado ou presente.") // Valida que a data de criação deve ser no passado ou presente
    private LocalDate createdAt;

    @PastOrPresent(message = "A data de atualização deve ser no passado ou presente.")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "user") // Define o relacionamento um-para-muitos com a entidade Address
    private List<Address> address;

    @OneToMany(mappedBy = "user") // Define o relacionamento um-para-muitos com a entidade Phone
    private List<Phone> phone;

    @OneToMany(mappedBy = "seller") // Define o relacionamento um-para-muitos com a entidade Product
    private List<Product> product;

    @PrePersist // Metodo executado antes de persistir o usuário no banco de dados
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

    @PreUpdate // Metodo executado antes de atualizar o usuário no banco de dados
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
}
