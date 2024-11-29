package dev.SpringBootAPI.ECommerce.validators.address;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ZipcodeValidator.class) // Classe que contém a lógica de validação
@Target({ElementType.FIELD, ElementType.PARAMETER}) // Onde a anotação pode ser aplicada
@Retention(RetentionPolicy.RUNTIME) // Disponível em tempo de execução
public @interface ValidZipcode {
    String message() default "CEP inválido"; // Mensagem de erro

    Class<?>[] groups() default {}; // Grupos de validação

    Class<? extends Payload>[] payload() default {}; // Informações adicionais
}
