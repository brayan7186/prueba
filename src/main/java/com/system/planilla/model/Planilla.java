package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PLANILLA")
@Getter
@Setter
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
		
}
