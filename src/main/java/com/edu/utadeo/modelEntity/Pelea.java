package com.edu.utadeo.modelEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="peleas")
public class Pelea implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	@Column
	private boolean ganada;
	
	@NotNull
	@JoinColumn(name="demonios.id")
	@JsonIgnoreProperties("listaPeleas")
	private Demonio demonio;
	

	public boolean isGanada() {
		return ganada;
	}

	public void setGanada(boolean ganada) {
		this.ganada = ganada;
	}

	public Demonio getDemonio() {
		return demonio;
	}

	public void setDemonio(Demonio demonio) {
		this.demonio = demonio;
	}

	public Pelea orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
