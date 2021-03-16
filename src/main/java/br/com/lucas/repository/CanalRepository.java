package br.com.lucas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.entity.Canal;

public interface CanalRepository extends JpaRepository<Canal, Long>  {

}
