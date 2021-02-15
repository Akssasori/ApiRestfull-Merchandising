package br.com.lucas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.entity.Agencia;
import br.com.lucas.repository.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository repo;
	
	public List<Agencia> listAll(){
		return repo.findAll();
	}
	
	public void save(Agencia agencia) {
		repo.save(agencia);
	}
	
	public Agencia get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
