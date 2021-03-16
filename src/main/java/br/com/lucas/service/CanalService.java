package br.com.lucas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.entity.Canal;
import br.com.lucas.repository.CanalRepository;

@Service
public class CanalService {

	@Autowired
	private CanalRepository repo;

	public List<Canal> listAll() {
		return repo.findAll();
	}

	public Canal get(long id) {
		return repo.findById(id).get();
	}

	public void Save(Canal canal) {
		repo.save(canal);
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
