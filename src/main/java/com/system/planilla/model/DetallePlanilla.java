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
	 
	 
	 @Column(name = "bonoInternet")
	 private  Double bonoInternet;
	 
	 @Column(name = "bonoMovilidad")
	 private  Double bonoMovilidad;
	 
	 
	 @Column(name = "descuentoAfp")
	 private  Double descuentoAfp;
	 
	 
	 @Column(name = "descuentoAfpSeguro")
	 private  Double descuentoAfpSeguro;
	 
	 @Column(name = "descuentoImpRenta")
	 private  Double descuentoImpRenta;
	 
	 
	 
	 @Column(name = "descuentoDia")
	 private  Double descuentoDia;
	 
	 @Column(name = "descuentoHora")
	 private  Double descuentoHora;
	 
	 
	 @Column(name = "cantidadHoraTardanza")
	 private  Double cantidadHoraTardanza;
	 
	 
	private Integer codPlanilla;
	
	/*@ManyToOne
	@JoinColumn(name = "codTrabajador", referencedColumnName = "codTrabajador")
	private Trabajador   trabajador;*/
	
	private Integer codTrabajador;
	
	
	
	public DetallePlanilla(){
		
	}
	
	
	

}