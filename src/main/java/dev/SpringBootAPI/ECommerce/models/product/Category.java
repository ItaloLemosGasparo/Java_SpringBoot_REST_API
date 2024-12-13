package dev.SpringBootAPI.ECommerce.models.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name can't be null.")
    @Size(min = 3, max = 100, message = "The name must have between 3 and 100 characters.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "The \"iconUrl\" can't be null.")
    @Size(max = 255, message = "The \"iconUrl\" can have 255 characters at maximum.")
    @Column(nullable = false, length = 255)
    private String iconUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_category_id")  // Define a chave estrangeira no banco de dados
    private Category previousCategory;
}
