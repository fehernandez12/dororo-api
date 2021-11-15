package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.dataAccessLayer.IPeleaDAO;
import com.edu.utadeo.modelEntity.Pelea;

@Service
public class PeleaService implements IPeleaService {
	@Autowired
	private IPeleaDAO peleaDao;

	@Override
	public List<Pelea> findAll() {
		// TODO Auto-generated method stub
		return peleaDao.findAll();
	}

	@Override
	public Pelea save(Pelea p) {
		// TODO Auto-generated method stub
		return peleaDao.save(p);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		peleaDao.deleteById(id);
	}

	@Override
	public Pelea findById(long id) {
		// TODO Auto-generated method stub
		Optional<Pelea> pelea = peleaDao.findById(id);
		if (pelea.isPresent()) {
			return pelea.get();
		} else {
			return null;
		}
	}

}
