package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.dataAccessLayer.IParteDAO;
import com.edu.utadeo.modelEntity.Parte;

@Service
public class ParteService implements IParteService {
	@Autowired
	private IParteDAO parteDao;

	@Override
	public List<Parte> findAll() {
		// TODO Auto-generated method stub
		return parteDao.findAll();
	}

	@Override
	public Parte save(Parte p) {
		// TODO Auto-generated method stub
		return parteDao.save(p);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		parteDao.deleteById(id);
	}

	@Override
	public Parte findById(long id) {
		// TODO Auto-generated method stub
		Optional<Parte> parte = parteDao.findById(id);
		if (parte.isPresent()) {
			return parte.get();
		} else {
			return null;
		}
	}

}
