package com.guilhermelevi.usuario.infrastructure.repository;

import com.guilhermelevi.usuario.infrastructure.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Long> {

    boolean existsByNome(String nome);
    Optional<ClienteEntity> findByTelefone(String telefone);

}
