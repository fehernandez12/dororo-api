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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="partes")
public class Parte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@NotNull
	@Column
	private String nombre;
	
	@OneToOne(mappedBy="parte", cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"parte", "lugar"})
	private Demonio demonio;
	

	public String getNombre() {
		return nombre;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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
