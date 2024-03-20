package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "DETALLE_PLANILLA")
public class DetallePlanilla {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codDetallePlanilla")
	private Integer   codDetallePlanilla;
	
	@Column(name = "sueldoBruto")
	private Double   sueldoBruto;
	
	 
	 
	 @Column(name = "bonificacion")
	 private  Double bonificacion;
	 
	 
	 @Column(name = "salarioNeto")
	 private  Double salarioNeto;
	 
	
	 @Column(name = "descuentoAfp")
	 private  Double descuentoAfp;
	 
	 
	 @Column(name = "descuentoAfpSeguro")
	 private  Double descuentoAfpSeguro;
	 
	 @Column(name = "descuentoImpRenta")
	 private  Double descuentoImpRenta;
	 
	 
	 
	 @Column(name = "codPlanilla")
	private Integer codPlanilla;
	
	 @Column( name = "codTrabajador")
	private Integer codTrabajador;
	
	
	

}