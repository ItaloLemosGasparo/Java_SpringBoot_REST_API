package dev.SpringBootAPI.ECommerce.models.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(exclude = "products")
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name can't be null.")
    @Size(min = 3, max = 100, message = "The name must have between 3 and 100 characters.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "The description can't be null.")
    @Size(min = 100, max = 2000, message = "The description must have between 100 and 2000 characters.")
    @Column(nullable = false, length = 2000)
    private String description;

    @NotNull(message = "The \"iconUrl\" can't be null.")
    @Size(max = 255, message = "The \"iconUrl\" can have 255 characters at maximum.")
    @Column(nullable = false, length = 255)
    private String iconUrl;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
