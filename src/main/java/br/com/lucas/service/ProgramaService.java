package br.com.lucas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.entity.Programa;
import br.com.lucas.repository.ProgramaRepository;

@Service
public class ProgramaService {
	
	@Autowired
	private ProgramaRepository repo;
	
	public List<Programa> listAll(){
		return repo.findAll();
	}
	
	public void save(Programa programa) {
		repo.save(programa);
	}
	
	public Programa get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
