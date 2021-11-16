package com.edu.utadeo.dataAccessLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Demonio;

public interface IDemonioDAO extends JpaRepository<Demonio, Long> {

	List<Demonio> findByDerrotadoTrue();

	List<Demonio> findByDerrotadoFalse();
	
}
