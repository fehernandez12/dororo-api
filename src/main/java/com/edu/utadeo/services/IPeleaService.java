package com.edu.utadeo.services;

import java.util.List;

import com.edu.utadeo.modelEntity.Pelea;

public interface IPeleaService {
public List<Pelea> findAll();
	
	public Pelea save(Pelea p);
	
	public void delete(long id);
	
	public Pelea findById(long id);
}
