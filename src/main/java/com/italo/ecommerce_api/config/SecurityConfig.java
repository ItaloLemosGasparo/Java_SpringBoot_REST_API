package com.italo.ecommerce_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Define o metodo que configura a segurança para os endpoints da aplicação
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Configura a segurança para as requisições HTTP
        http
                // Desabilita a proteção CSRF, pois a autenticação será feita com JWT (JSON Web Token)
                // Para APIs REST que usam JWT, o CSRF não é necessário, pois o token de autenticação já garante a segurança da requisição
                .csrf(csrf -> csrf.disable())
                .authorizeRequests() // Define as regras de autorização para as requisições
                .requestMatchers("/api/**").permitAll() // Permite que qualquer um acesse os endpoints que começam com "/api/", sem autenticação
                .anyRequest().authenticated(); // Exige autenticação para qualquer outra requisição (não especificada acima)

        // Retorna a configuração da cadeia de filtros de segurança
        return http.build();
    }
}
