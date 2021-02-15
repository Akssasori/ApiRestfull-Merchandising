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

import br.com.lucas.entity.Programa;
import br.com.lucas.service.ProgramaService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class ProgramaController {
	
	@Autowired
	private ProgramaService service;
	
	@GetMapping("/programas")
	public List<Programa> list(){
		return service.listAll();
	}
	
	@GetMapping("/programas/{id}")
	public ResponseEntity<Programa>get(@PathVariable Long id){
		try {
			Programa programa = service.get(id);
			return new ResponseEntity<Programa>(programa,HttpStatus.OK);
			
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Programa>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/programas")
	public void add(@RequestBody Programa programa) {
		service.save(programa);
		System.out.println("Programa gravado com sucesso!");
	}
	
	@PutMapping("/programas/{id}")
	public ResponseEntity<?> update(@RequestBody Programa programa,@PathVariable Long id){
		try {
			Programa existPrograma = service.get(id);
			service.save(programa);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/programas/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
