package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.Lugar;

public interface ILugarService {
	public List<Lugar> findAll();
	
	public Lugar save(Lugar l);
	
	public void delete(long id);
	
	public Lugar findById(long id);
}
