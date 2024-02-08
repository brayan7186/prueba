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
@Table(name = "TB_TRABAJADOR")
public class Trabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codTrabajador")
	private Integer codTrabajador;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column(name = "apePaterno" , length = 50)
	private String apePaterno;
	
	@Column(name = "apeMaterno", length = 50)
	private String apeMaterno;
	
	@Column(name = "correo", length = 150)
	private String correo;
	
	@Column(name = "edad")
	private Integer edad;
	
	@Column(name = "celular", length = 10)
	private String celular;
	
	@Column(name = "direccion", length = 150)
	private String direccion;
	
	@Column(name = "dni", length = 8)
	private String dni;
	

	@ManyToOne
	@JoinColumn(name = "codEstCivil", referencedColumnName = "codEstCivil")
	private EstadoCivil estadoCivil;
	
	@ManyToOne
	@JoinColumn(name = "codArea" ,referencedColumnName = "codArea")
	private Area area;
	
	@ManyToOne
	@JoinColumn(name = "codCargo", referencedColumnName = "codCargo")
	private Cargo cargo;



  public Trabajador () {
	
 }
	
	
	
	public Trabajador(Integer codTrabajador2) {
		
		  this.codTrabajador = codTrabajador2 ;
	}



	public Integer getCodTrabajador() {
		return codTrabajador;
	}







	public void setCodTrabajador(Integer codTrabajador) {
		this.codTrabajador = codTrabajador;
	}

	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApePaterno() {
		return apePaterno;
	}


	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}




	public String getApeMaterno() {
		return apeMaterno;
	}


	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getEdad() {
		return edad;
	}



	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}



	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}



	public Cargo getCargo() {
		return cargo;
	}



	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}


	

}