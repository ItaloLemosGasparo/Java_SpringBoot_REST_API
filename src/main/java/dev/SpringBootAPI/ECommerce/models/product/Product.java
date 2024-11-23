package dev.SpringBootAPI.ECommerce.models.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "A descrição não pode ser nula.")
    @Size(min = 100, max = 2000, message = "A descrição deve ter entre 100 e 2000 caracteres.")
    @Column(nullable = false, length = 2000)
    private  String description;

    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que 0.")
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull(message = "A quantidade não pode ser nula.")
    @Min(value = 0, message = "A quantidade deve ser no mínimo 0.")
    @Column(nullable = false)
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull(message = "A marca não pode ser nula.")
    @Size(min = 3, max = 100, message = "A marca deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String brand;

    @OneToMany(mappedBy = "product")
    private List<ProductImages> images;

    @NotNull(message = "A data de criação não pode ser nula.")
    @PastOrPresent(message = "A data de criação deve ser no passado ou presente.")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "A data de atualização deve ser no passado ou presente.")
    private LocalDateTime updatedAt;

    private boolean status;

    @NotNull(message = "O peso não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = true, message = "O peso não pode ser menor que 0.")
    @Column(nullable = false)
    private BigDecimal weight;

    @Embedded
    private Dimension dimension;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
