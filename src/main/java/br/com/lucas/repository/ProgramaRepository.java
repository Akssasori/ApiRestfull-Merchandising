package br.com.lucas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.entity.Programa;

public interface ProgramaRepository extends JpaRepository<Programa, Long> {

}
