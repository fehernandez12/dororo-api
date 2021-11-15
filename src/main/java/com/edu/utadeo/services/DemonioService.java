package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

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
		Optional<Demonio> demonio = demonioDao.findById(id);
		if (demonio.isPresent()) {
			return demonio.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Demonio> getDerrotados() {
		// TODO Auto-generated method stub
		return demonioDao.findByDerrotadoTrue();
	}

	@Override
	public List<Demonio> getInvictos() {
		// TODO Auto-generated method stub
		return demonioDao.findByDerrotadoFalse();
	}
}
