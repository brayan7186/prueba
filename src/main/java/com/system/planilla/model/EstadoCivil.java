package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ESTADO_CIVIL")
public class EstadoCivil {

	@Id
	@Column(name = "codEstCivil")
	private Integer codEstCivil;
	
	@Column(name = "descripcion")
	private String descripcion;

	
	
	  public EstadoCivil() {
		
	}
	

	
	public EstadoCivil(Integer codEstCivil2) {
		
		this.codEstCivil = codEstCivil2;
	}

	@Override
	public String toString() {
		return "EstadoCivil [codEstCivil=" + codEstCivil + ", descripcion=" + descripcion + "]";
	}

	public Integer getCodEstCivil() {
		return codEstCivil;
	}

	public void setCodEstCivil(Integer codEstCivil) {
		this.codEstCivil = codEstCivil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
