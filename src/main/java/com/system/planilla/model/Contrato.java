package com.system.planilla.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	private LocalDate fechaInicio;
	
	@Column(name = "fechaFin")
	private LocalDate fechaFin;
	
	@Column(name = "sueldoBruto")
	private Double sueldoBruto;
	
	@Column(name = "bonificacion")
	private Double bonificacion;
	
	 
	@Column(name = "estado" ,length = 10)
	private String estado;
	
	
	
	@ManyToOne
	@JoinColumn(name = "codTrabajador" ,referencedColumnName ="codTrabajador")
	private Trabajador trabajador;
	
	
	
	
	
	
	
	
	

	
	
}
