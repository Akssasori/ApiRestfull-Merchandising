package br.com.lucas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
