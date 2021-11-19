package com.edu.utadeo.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edu.utadeo.modelEntity.Demonio;
import com.edu.utadeo.modelEntity.Parte;
import com.edu.utadeo.modelEntity.Pelea;
import com.edu.utadeo.services.IDemonioService;
import com.edu.utadeo.services.IParteService;
import com.edu.utadeo.services.IPeleaService;

@RestController
@RequestMapping("/api/demonios")
@CrossOrigin(origins="*", allowedHeaders="*")
public class DemonioController {
	@Autowired
	private IDemonioService demonioService;
	
	@Autowired
	private IParteService parteService;
	
	@Autowired
	private IPeleaService peleaService;
	
	@GetMapping("/")
	public List<Demonio> listAll() {
		return demonioService.findAll();
	}
	
	@GetMapping("/derrotados")
	public List<Demonio> getDerrotados() {
		return demonioService.getDerrotados();
	}
	
	@GetMapping("/invictos")
	public List<Demonio> getInvictos() {
		return demonioService.getInvictos();
	}
	
	@GetMapping("/{id}")
	public Demonio detail(@PathVariable long id) {
		return demonioService.findById(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> save(@Valid @RequestBody Demonio d, 
			BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Demonio demon = new Demonio();
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for (FieldError err: result.getFieldErrors()) {
				errors.add(err.getField());
			}
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.BAD_REQUEST);
		}
		try {
			demon = d;
			Date fechaActual = new Date();
			demon.setFechaCreacion(fechaActual);
			d = demonioService.save(demon);
		}
		catch (Exception ex) {
			response.put("Mensaje", ex.getMessage());
			return new ResponseEntity<Map<String, Object>>(
					response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Demonio>(demon, HttpStatus.OK);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,
			@RequestParam("id") long id) {
		Map<String, Object> response = new HashMap<>();
		Demonio current = demonioService.findById(id);
		if (!file.isEmpty()) {
			String nombre = UUID.randomUUID() +
					"_" + file.getOriginalFilename().replaceAll(" ", "");
			Path path = Paths.get("media")
					.resolve(nombre)
					.toAbsolutePath();
			try {
				Files.copy(file.getInputStream(), path);
			}
			catch (Exception ex) {
				response.put("Mensaje", ex.getMessage());
				return new ResponseEntity<Map<String, Object>>(
						response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			String currentImg = current.getImagen();
			if (currentImg != null && currentImg.length() > 0) {
				Path previousPath = Paths.get("media")
						.resolve(currentImg)
						.toAbsolutePath();
				File previousImg = previousPath.toFile();
				if (previousImg.canRead() && previousImg.exists()) {
					previousImg.delete();
				}
			}
			current.setImagen(nombre);
			demonioService.save(current);
			response.put("Mensaje", "La imagen fue subida exitosamente");
			response.put("Demonio", current);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/upload/img/{nombrefoto:.+}")
	public ResponseEntity<Resource> seeImage(@PathVariable String img) {
		Path path = Paths.get("media")
				.resolve(img)
				.toAbsolutePath();
		Resource res = null;
		try {
			res = new UrlResource(path.toUri());
		}
		catch (Exception ex) {
			
		}
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, 
				"attachment;filename=\"" + 
				res.getFilename() + "\""
		);
		return new ResponseEntity<Resource>(res, header, HttpStatus.OK);
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
		Parte parteActual = parteService.findById(
				current
				.getParte()
				.getId()
		);
		current.setFechaDerrota(fechaActual);
		current.setDerrotado(true);
		current.setParte(null);
		parteActual.setDemonio(null);
		Pelea pelea = new Pelea();
		pelea.setGanada(true);
		pelea.setDemonio(current);
		peleaService.save(pelea);
		parteService.save(parteActual);
		return demonioService.save(current);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Demonio update(@PathVariable long id, @RequestBody Demonio d) {
		Demonio current = demonioService.findById(id);
		current.setNombre(d.getNombre());
		current.setLugar(d.getLugar());
		current.setImagen(d.getImagen());
		return demonioService.save(current);
	}
}
