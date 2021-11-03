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

import com.edu.utadeo.services.IParteService;
import com.edu.utadeo.modelEntity.Parte;

@RestController
@RequestMapping("/api/partes")
@CrossOrigin(origins="*", allowedHeaders="*")
public class ParteController {
	@Autowired
	private IParteService parteService;
	
	@GetMapping("/")
	public List<Parte> findAll(){
		return parteService.findAll();
	}
	
	@GetMapping("/{id}")
	public Parte detail(@PathVariable long id) {
		return parteService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Parte save(@RequestBody Parte p) {
		return parteService.save(p);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		parteService.delete(id);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Parte edit(@PathVariable long id) {
		Parte current = parteService.findById(id);
		current.setNombre(current.getNombre());
		return parteService.save(current);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Parte update(@PathVariable long id, @RequestBody Parte p) {
		Parte actual = parteService.findById(id);
		actual.setNombre(p.getNombre());
		actual.setDemonio(p.getDemonio());
		return parteService.save(actual);
	}
}