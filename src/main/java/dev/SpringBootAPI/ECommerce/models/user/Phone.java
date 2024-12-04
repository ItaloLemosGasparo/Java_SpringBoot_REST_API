package dev.SpringBootAPI.ECommerce.models.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "Phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O DDD não pode ser nulo.")
    @Pattern(regexp = "^\\d{2}$", message = "O DDD deve ter exatamente 2 dígitos.")
    @Column(nullable = false, length = 2)
    private String ddd;

    @NotNull(message = "O número de telefone não pode ser nulo.")
    @Pattern(regexp = "^\\d{8,9}$", message = "O número de telefone deve ter entre 8 e 9 dígitos.")
    @Column(nullable = false, length = 9)
    private String number;

    private boolean confirmed = false;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
