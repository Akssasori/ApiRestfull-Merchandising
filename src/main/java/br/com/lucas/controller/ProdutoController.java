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

import br.com.lucas.entity.Produto;
import br.com.lucas.service.ProdutoService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/produtos")
	public List<Produto>list(){
		return service.listAll();
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto>get(@PathVariable Long id){
		try {
			Produto produto = service.get(id);
			return new ResponseEntity<Produto>(produto,HttpStatus.OK);
			
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/produtos")
	public void add(@RequestBody Produto produto) {
		service.save(produto);
		System.out.println("gravado");
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<?>update(@RequestBody Produto produto, @PathVariable Long id){
		try {
			Produto existProduto = service.get(id);
			service.save(produto);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/produtos/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
	

}
