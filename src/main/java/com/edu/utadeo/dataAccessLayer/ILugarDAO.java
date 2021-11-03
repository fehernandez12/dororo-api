package com.edu.utadeo.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Lugar;

public interface ILugarDAO extends JpaRepository<Lugar, Long> {

}
