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

import com.edu.utadeo.modelEntity.Lugar;
import com.edu.utadeo.services.ILugarService;

@RestController
@RequestMapping("/api/lugares")
@CrossOrigin(origins="*", allowedHeaders="*")
public class LugarController {
	@Autowired
	private ILugarService lugarService;
	
	@GetMapping("/")
	public List<Lugar> findAll(){
		return lugarService.findAll();
	}
	
	@GetMapping("/{id}")
	public Lugar detail(@PathVariable long id) {
		return lugarService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Lugar save(@RequestBody Lugar l) {
		return lugarService.save(l);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		lugarService.delete(id);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Lugar edit(@PathVariable long id) {
		Lugar current = lugarService.findById(id);
		current.setNombre(current.getNombre());
		return lugarService.save(current);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Lugar update(@PathVariable long id, @RequestBody Lugar l) {
		Lugar actual = lugarService.findById(id);
		actual.setNombre(l.getNombre());
		actual.setListaDemonios(l.getListaDemonios());
		return lugarService.save(actual);
	}
}
