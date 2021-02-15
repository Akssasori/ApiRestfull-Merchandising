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

import br.com.lucas.entity.Cliente;
import br.com.lucas.service.ClienteService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="*")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/clientes")
	public List<Cliente> list(){
		return service.listAll();
	}
	
	@GetMapping("clientes/{id}")
	public ResponseEntity<Cliente> get(@PathVariable Long id){
		try {
			Cliente cliente = service.get(id);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/clientes")
	public void add(@RequestBody Cliente cliente) {
		service.save(cliente);
		System.out.println("Cliente gravado com sucesso!");
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente cliente,
			@PathVariable Long id){
		try {
			Cliente existCliente = service.get(id);
			service.save(cliente);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/clientes/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	

}
