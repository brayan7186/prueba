package com.system.planilla.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONTRATO")
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codContrato")
	private Integer codContrato;
	
	@Column(name = "modContrato" ,length = 50)
	private String modContrato;
	
	@Column(name = "fechaInicio")
	private Date fechaInicio;
	
	@Column(name = "fechaFin")
	private Date fechaFin;
	
	@Column(name = "sueldoBruto")
	private Double sueldoBruto;
	
	@Column(name = "bonificacion")
	private Double bonificacion;
	
	@ManyToOne
	@JoinColumn(name = "codTrabajador" ,referencedColumnName ="codTrabajador")
	private Trabajador trabajador;
	
	
	
	
	
	
	
	
	
	
	
	public Integer getCodContrato() {
		return codContrato;
	}
	public void setCodContrato(Integer codContrato) {
		this.codContrato = codContrato;
	}
	public String getModContrato() {
		return modContrato;
	}
	public void setModContrato(String modContrato) {
		this.modContrato = modContrato;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Double getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(Double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	public Double getBonificacion() {
		return bonificacion;
	}
	public void setBonificacion(Double bonificacion) {
		this.bonificacion = bonificacion;
	}
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	
	
	
	
	
	
	

	
	
}
