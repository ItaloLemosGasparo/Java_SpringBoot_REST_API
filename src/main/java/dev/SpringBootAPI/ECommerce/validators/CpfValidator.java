package dev.SpringBootAPI.ECommerce.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<ValidCpf, String> {

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int firstVerifier = 11 - (sum % 11);
        if (firstVerifier == 10 || firstVerifier == 11) {
            firstVerifier = 0;
        }
        if (firstVerifier != (cpf.charAt(9) - '0')) {
            return false;
        }

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int secondVerifier = 11 - (sum % 11);
        if (secondVerifier == 10 || secondVerifier == 11) {
            secondVerifier = 0;
        }
        return secondVerifier == (cpf.charAt(10) - '0');
    }
}
