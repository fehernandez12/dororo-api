package com.edu.utadeo.modelEntity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="partes")
public class Parte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nombre;
	
	@OneToOne(mappedBy="parte", cascade=CascadeType.ALL)
	private Demonio demonio;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Demonio getDemonio() {
		return demonio;
	}

	public void setDemonio(Demonio demonio) {
		this.demonio = demonio;
	}
	
	public Parte orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
