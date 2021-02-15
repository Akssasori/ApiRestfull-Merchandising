package br.com.lucas.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.entity.Agencia;
import br.com.lucas.service.AgenciaService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class AgenciaController {
	
	@Autowired
	private AgenciaService service;
	
	@GetMapping("/agencias")
	public List<Agencia> list(){
		return service.listAll();
	}
	
	@GetMapping("agencias/{id}")
	public ResponseEntity<Agencia> get(@PathVariable Long id){
		try {
			Agencia agencia = service.get(id);
			return new ResponseEntity<Agencia>(agencia, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Agencia>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void add(@RequestBody Agencia agencia) {
		service.save(agencia);
		System.out.println("Agencia salva com sucesso!");
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@RequestBody Agencia agencia,
			@PathVariable Long id){
		try {
			Agencia existAgencia = service.get(id);
			service.save(agencia);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/Agencias/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	

}
