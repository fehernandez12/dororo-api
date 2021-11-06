package com.edu.utadeo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edu.utadeo.modelEntity.Demonio;
import com.edu.utadeo.services.IDemonioService;

@RestController
@RequestMapping("/api/demonios")
@CrossOrigin(origins="*", allowedHeaders="*")
public class DemonioController {
	@Autowired
	private IDemonioService demonioService;
	
	@GetMapping("/")
	public List<Demonio> listAll() {
		return demonioService.findAll();
	}
	
	@GetMapping("/{id}")
	public Demonio detail(@PathVariable long id) {
		return demonioService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Demonio save(@RequestBody Demonio d) {
		Demonio demon = d;
		Date fechaActual = new Date();
		demon.setFechaCreacion(fechaActual);
		return demonioService.save(demon);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		demonioService.delete(id);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Demonio derrotar(@PathVariable long id) {
		Demonio current = demonioService.findById(id);
		Date fechaActual = new Date();
		current.setFechaDerrota(fechaActual);
		current.setDerrotado(true);
		return demonioService.save(current);
	}
}
