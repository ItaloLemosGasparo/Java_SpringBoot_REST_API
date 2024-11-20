package com.italo.ecommerce_api.repositories;

import com.italo.ecommerce_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Extende a interface JpaRepository, o que automaticamente fornece vários métodos padrão para manipulação de dados.

    // JpaRepository<User, Long>:
    // - User: Tipo da entidade que este repositório vai gerenciar.
    // - Long: Tipo do ID da entidade (neste caso, a chave primária é do tipo Long).

    // Métodos embutidos herdados de JpaRepository:
    // - save(User entity): Salva ou atualiza um objeto do tipo User no banco de dados.
    // - findById(Long id): Busca um User pelo seu ID.
    // - findAll(): Retorna todos os registros da entidade User no banco.
    // - deleteById(Long id): Remove um User pelo ID.
    // - count(): Retorna o número total de registros na tabela User.
    // - existsById(Long id): Verifica se existe um User com o ID fornecido.
    // E vários outros métodos padrão para manipulação de dados.

    // Metodos adicionais:
    Optional<User> findByEmail(String email);
    // Este é um metodo personalizado que não faz parte dos métodos padrão do JpaRepository.
    // - Será implementado automaticamente pelo Spring Data JPA com base na convenção de nomes.
    // - "findByUsername": O Spring Data JPA entende que deve criar uma consulta para buscar um registro
    //   na tabela "User" com base no campo "username".
    // - "username" precisa ser um atributo existente na entidade User.
}
