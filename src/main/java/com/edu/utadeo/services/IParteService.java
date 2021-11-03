package com.edu.utadeo.services;

import java.util.List;
import com.edu.utadeo.modelEntity.Parte;

public interface IParteService {
	public List<Parte> findAll();
	
	public Parte save(Parte p);
	
	public void delete(long id);
	
	public Parte findById(long id);
}
