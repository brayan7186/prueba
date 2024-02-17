package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "DETALLE_PLANILLA")
public class DetallePlanilla {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codDetallePlanilla")
	private Integer   codDetallePlanilla;
	
	@Column(name = "sueldoBruto")
	private Double   sueldoBruto;
	
	 
	 @Column(name = "diaNoLaborado")
	 private  Double diaNoLaborado;
	 
	 @Column(name = "bonoAlimento")
	 private  Double bonoAlimeto;
	 
	 
	 @Column(name = "salarioNeto")
	 private  Double salarioNeto;
	 
	/*@ManyToOne
	@JoinColumn(name = "codPlanilla", referencedColumnName = "codPlanilla")
	private Planilla   planilla;*/
	
	private Integer codPlanilla;
	
	/*@ManyToOne
	@JoinColumn(name = "codTrabajador", referencedColumnName = "codTrabajador")
	private Trabajador   trabajador;*/
	
	private Integer codTrabajador;
	
	
	
	public DetallePlanilla(){
		
	}
	
	
	

}