package dev.SpringBootAPI.ECommerce.models.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "ProductImages")
public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A URL da imagem não pode ser nula.")
    @Size(max = 255, message = "A URL da imagem deve ter no máximo 255 caracteres.")
    @Column(nullable = false, length = 255)
    private String url;

    @NotNull(message = "O tipo da imagem não pode ser nulo.")
    @Size(max = 50, message = "O tipo da imagem deve ter no máximo 50 caracteres.")
    @Column(nullable = false, length = 50)
    private String type;

    @Column
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
