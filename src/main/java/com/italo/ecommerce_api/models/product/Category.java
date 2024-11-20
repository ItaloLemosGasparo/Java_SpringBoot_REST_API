package com.italo.ecommerce_api.models.product;

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

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "A descrição não pode ser nula.")
    @Size(min = 100, max = 2000, message = "A descrição deve ter entre 100 e 2000 caracteres.")
    @Column(nullable = false, length = 2000)
    private String description;

    @NotNull(message = "O ícone não pode ser nulo.")
    @Size(max = 255, message = "A URL do ícone deve ter no máximo 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String iconUrl;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
