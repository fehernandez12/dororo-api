package com.edu.utadeo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.edu.utadeo.modelEntity.Pelea;
import com.edu.utadeo.services.IPeleaService;

@RestController
@RequestMapping("/api/peleas")
@CrossOrigin(origins="*", allowedHeaders="*")
public class PeleaController {
	@Autowired
	private IPeleaService peleaService;
	
	@GetMapping("/")
	public List<Pelea> listAll() {
		return peleaService.findAll();
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Pelea save(@RequestBody Pelea p) {
		return peleaService.save(p);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		peleaService.delete(id);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Pelea ganar(@PathVariable long id) {
		Pelea current = peleaService.findById(id);
		current.setGanada(!current.isGanada());
		return peleaService.save(current);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Pelea update(@PathVariable long id, @RequestBody Pelea p) {
		Pelea actual = peleaService.findById(id);
		actual.setDemonio(p.getDemonio());
		actual.setGanada(p.isGanada());
		return peleaService.save(actual);
	}
}
