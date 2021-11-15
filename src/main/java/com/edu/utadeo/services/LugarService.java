package com.edu.utadeo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.utadeo.dataAccessLayer.ILugarDAO;
import com.edu.utadeo.modelEntity.Lugar;

@Service
public class LugarService implements ILugarService {
	@Autowired
	private ILugarDAO lugarDao;

	@Override
	public List<Lugar> findAll() {
		// TODO Auto-generated method stub
		return lugarDao.findAll();
	}

	@Override
	public Lugar save(Lugar l) {
		// TODO Auto-generated method stub
		return lugarDao.save(l);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		lugarDao.deleteById(id);
	}

	@Override
	public Lugar findById(long id) {
		// TODO Auto-generated method stub
		Optional<Lugar> lugar = lugarDao.findById(id);
		if (lugar.isPresent()) {
			return lugar.get();
		} else {
			return null;
		}
	}

}
