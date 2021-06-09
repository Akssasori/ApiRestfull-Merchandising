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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.entity.Acao;
import br.com.lucas.service.AcaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@ResponseBody
@RequestMapping("api/v1")
@Api(value="API REST ApoioMerchan")
@CrossOrigin(origins="*")
public class AcaoController {
	
	@Autowired
	private AcaoService service;
	
	@GetMapping("/acoes")
	@ApiOperation(value="Retorna as a��es")
	public List<Acao> list(){
		return service.listAll();
		
	}
	
	@GetMapping("/acoes/{id}")
	@ApiOperation(value="Retorna uma a��o unica por id")
	public ResponseEntity<Acao> get(@PathVariable Long id){
		try {
			Acao acao = service.get(id);
			return new ResponseEntity<Acao>(acao,HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Acao>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@PostMapping("/acoes")
//	@ApiOperation(value="Salava um a��o")
//	public void add(@RequestBody Acao acao) {
//		service.save(acao);
//		System.out.println("gravado com sucesso!");
//		
//	}
	
	@PostMapping("/acoes")
	@ApiOperation(value="Salava um a��o")
	public ResponseEntity<?>add(@RequestBody Acao acao) {
		try {
			service.save(acao);
//			return new ResponseEntity<>(HttpStatus.OK);
			return ResponseEntity.status(200).body(acao);
		}catch(NoSuchElementException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Erro: "+ e.getMessage());
		}
		
	}
	
	@PutMapping("/acoes/{id}")
	@ApiOperation(value="Atualiza uma a��o")
	public ResponseEntity<?> update(@RequestBody Acao acao,
			@PathVariable Long id){
		try {
			Acao existAcao = service.get(id);
			service.save(acao);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/acoes/{id}")
	@ApiOperation(value="deleta uma a��o")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	

}

