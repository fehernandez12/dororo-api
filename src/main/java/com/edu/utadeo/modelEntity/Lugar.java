package com.edu.utadeo.modelEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lugares")
public class Lugar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<Demonio> listaDemonios = new ArrayList<>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Demonio> getListaDemonios() {
		return listaDemonios;
	}

	public void setListaDemonios(List<Demonio> listaDemonios) {
		this.listaDemonios = listaDemonios;
	}

	public Lugar orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
