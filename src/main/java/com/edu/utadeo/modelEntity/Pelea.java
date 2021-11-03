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

@Entity
@Table(name="peleas")
public class Pelea implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private boolean ganada;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="demonios.id")
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
