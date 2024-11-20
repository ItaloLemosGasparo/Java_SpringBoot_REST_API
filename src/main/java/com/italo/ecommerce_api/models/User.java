package com.italo.ecommerce_api.models;

import com.italo.ecommerce_api.validators.ValidCpf;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data //gera os getter, setter, toString()
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
    private String name;

    @NotNull(message = "O email não pode ser nulo.")
    @Email(message = "O email deve ser válido.") // Validação de formato de email.
    @Column(unique = true)
    private String email;

    @NotNull(message = "A senha não pode ser nula.")
    private String password;

    @NotNull(message = "O CPF não pode ser nulo.")
    @Column(unique = true)
    @ValidCpf
    private String cpf;


    @NotNull(message = "A data de nascimento não pode ser nula.")
    @Past(message = "A data de nascimento deve ser uma data passada.") // Validação para garantir que a data seja no passado.
    private LocalDate birthDate;

    @NotNull(message = "O telefone não pode ser nulo.")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 dígitos.")
    private String phone;

    @Embedded // Indica que a classe Address será incorporada diretamente como parte desta entidade.
    private Address address;

    @Enumerated(EnumType.STRING) // Armazena o enum como string no banco de dados.
    @NotNull(message = "O tipo de usuário não pode ser nulo.")
    private UserType userType;

    private Boolean active = true; // Indica se o usuário está ativo. Valor padrão definido como true.

    @NotNull(message = "A data de criação não pode ser nula.")
    @PastOrPresent(message = "A data de criação deve ser no passado ou presente.") // Garante que a data de criação seja válida.
    private LocalDate createdAt;

    @PastOrPresent(message = "A data de atualização deve ser no passado ou presente.") // Garante que a data de atualização seja válida.
    private LocalDate updatedAt;

    @PrePersist // Executado antes de a entidade ser persistida no banco de dados.
    public void prePersist() {
        this.createdAt = LocalDate.now(); // Define a data de criação como a data atual.
    }

    @PreUpdate // Executado antes de a entidade ser atualizada no banco de dados.
    public void preUpdate() {
        this.updatedAt = LocalDate.now(); // Define a data de atualização como a data atual.
    }
}
