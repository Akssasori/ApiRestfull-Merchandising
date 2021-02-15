package br.com.lucas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.entity.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

}
