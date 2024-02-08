package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLE_PLANILLA")
public class DetallePlanilla {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codDetallePlanilla")
	private Integer   codDetallePlanilla;
	
	@Column(name = "sueldoBruto")
	private Double   sueldoBruto;
	
	@Column(name = "onp")
	 private  Double onp;
	 
	@Column(name = "afp")
	 private Double afp;
	
	@Column(name = "impuestoRenta")
	 private Double impuestoRenta;
	 
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
	
	
	
	public Integer getCodDetallePlanilla() {
		return codDetallePlanilla;
	}

	public void setCodDetallePlanilla(Integer codDetallePlanilla) {
		this.codDetallePlanilla = codDetallePlanilla;
	}

	



	public Double getSueldoBruto() {
		return sueldoBruto;
	}



	public void setSueldoBruto(Double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}



	public Double getOnp() {
		return onp;
	}



	public void setOnp(Double onp) {
		this.onp = onp;
	}



	public Double getAfp() {
		return afp;
	}



	public void setAfp(Double afp) {
		this.afp = afp;
	}



	public Double getImpuestoRenta() {
		return impuestoRenta;
	}



	public void setImpuestoRenta(Double impuestoRenta) {
		this.impuestoRenta = impuestoRenta;
	}



	public Double getSalarioNeto() {
		return salarioNeto;
	}



	public void setSalarioNeto(Double salarioNeto) {
		this.salarioNeto = salarioNeto;
	}



	public Integer getCodPlanilla() {
		return codPlanilla;
	}



	public void setCodPlanilla(Integer codPlanilla) {
		this.codPlanilla = codPlanilla;
	}



	public Integer getCodTrabajador() {
		return codTrabajador;
	}



	public void setCodTrabajador(Integer codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	/*public Planilla getPlanilla() {
		return planilla;
	}

	public void setPlanilla(Planilla planilla) {
		this.planilla = planilla;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}*/
	
	
}