package com.edu.utadeo.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Parte;

public interface IParteDAO extends JpaRepository<Parte, Long> {

}
