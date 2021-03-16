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

import br.com.lucas.entity.Canal;
import br.com.lucas.service.CanalService;

@RestController
@ResponseBody
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class CanalController {

	@Autowired
	private CanalService service;

	@GetMapping("/canais")
	public List<Canal> list() {
		return service.listAll();

	}

	@GetMapping("/canais/{id}")
	public ResponseEntity<Canal> get(@PathVariable long id) {
		try {
			Canal canal = service.get(id);
			return new ResponseEntity<Canal>(canal, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Canal>(HttpStatus.NOT_FOUND);

		}

	}

	@PutMapping("/canais/{id}")
	public ResponseEntity<?> get(@RequestBody Canal canal, @PathVariable long id) {
		try {
			Canal existCanal = service.get(id);
			service.Save(canal);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
	@DeleteMapping("/canais/{id}")
	public void delete(@PathVariable long id) {
		service.delete(id);
	}
	
	@PostMapping("/canais")
	public void add(@RequestBody Canal canal) {
		service.Save(canal);
		
	}

}
