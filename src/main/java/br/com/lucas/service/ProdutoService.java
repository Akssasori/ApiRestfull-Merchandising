package br.com.lucas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.entity.Produto;
import br.com.lucas.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public List<Produto>listAll(){
		return repo.findAll();
	}
	
	
	

}
