package br.com.lucas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.entity.Acao;
import br.com.lucas.repository.AcaoRepository;

@Service
public class AcaoService {
	
	@Autowired
	private AcaoRepository repo;
	
	public List<Acao> listAll(){
		return repo.findAll();
		
	}
	
	public void save(Acao acao) {
		repo.save(acao);
	}
	
//	public void saveAll(Acao acao) {
//		repo.saveAll((List<Acao>) acao);
//	}
	
	public Acao get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}



