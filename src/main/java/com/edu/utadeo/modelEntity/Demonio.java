package com.edu.utadeo.modelEntity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="demonios",
		uniqueConstraints = {@UniqueConstraint(columnNames="nombre")})
public class Demonio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Size(min=2, max=24)
	@NotNull
	@Column
	private String nombre;
	
	@Column
	private String imagen;
	
	@Column
	private boolean derrotado;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaCreacion;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechaDerrota;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="lugares.id")
	@JsonIgnoreProperties({"listaDemonios"})
	private Lugar lugar;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="parte")
	@JsonIgnoreProperties("listaDemonios")
	private Parte parte;
	
	@OneToOne
	@JoinColumn(name="pelea")
	@JsonIgnoreProperties("listaDemonios")
	private Pelea pelea;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaDerrota() {
		return fechaDerrota;
	}

	public void setFechaDerrota(Date fechaDerrota) {
		this.fechaDerrota = fechaDerrota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isDerrotado() {
		return derrotado;
	}

	public void setDerrotado(boolean derrotado) {
		this.derrotado = derrotado;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Parte getParte() {
		return parte;
	}

	public void setParte(Parte parte) {
		this.parte = parte;
	}

	public Pelea getPelea() {
		return pelea;
	}

	public void setPelea(Pelea pelea) {
		this.pelea = pelea;
	}

	public Demonio orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
