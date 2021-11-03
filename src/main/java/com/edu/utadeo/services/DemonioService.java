package com.edu.utadeo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.dataAccessLayer.IDemonioDAO;
import com.edu.utadeo.modelEntity.Demonio;

@Service
public class DemonioService implements IDemonioService {
	@Autowired
	private IDemonioDAO demonioDao;
	
	@Override
	public List<Demonio> findAll(){
		return demonioDao.findAll();
	}
	
	@Override
	public Demonio save(Demonio d) {
		return demonioDao.save(d);
	}
	
	@Override
	public void delete(long id) {
		demonioDao.deleteById(id);
	}
	
	@Override
	public Demonio findById(long id) {
		return demonioDao.getById(id).orElse(null);
	}
}
