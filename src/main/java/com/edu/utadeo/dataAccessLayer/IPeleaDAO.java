package com.edu.utadeo.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.utadeo.modelEntity.Pelea;

public interface IPeleaDAO extends JpaRepository<Pelea, Long> {

}
