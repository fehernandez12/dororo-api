package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.Demonio;

public interface IDemonioService {
	public List<Demonio> findAll();
	
	public Demonio save(Demonio d);
	
	public void delete(long id);
	
	public Demonio findById(long id);
}
