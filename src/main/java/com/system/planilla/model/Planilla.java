package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLANILLA")
public class Planilla {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codPlanilla")
	private Integer codPlanilla;
	
	@Column(name = "descripcion" ,length = 50)
	private  String descripcion;
		    
	@Column(name = "anio" )
	private	Integer  anio;
	
	@Column(name = "mes" ,length = 50)
	private  String mes;
	
	@Column(name = "montoTotal")
	private Double montoTotal;

	
	
   public Planilla() {
		
		
	}
	
	public Planilla(Integer codPlanilla2) {
		
		this.codPlanilla = codPlanilla2;
	}
	
	
	
	
	
	
	
	public Integer getCodPlanilla() {
		return codPlanilla;
	}

	public void setCodPlanilla(Integer codPlanilla) {
		this.codPlanilla = codPlanilla;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	
	
	
	
	
	
}
