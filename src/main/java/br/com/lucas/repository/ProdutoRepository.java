package br.com.lucas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
