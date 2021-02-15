package br.com.lucas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.entity.Acao;
@Repository
public interface AcaoRepository extends JpaRepository<Acao, Long> {

}



