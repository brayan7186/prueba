package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter
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
	
	
	
	/*@Column(name = "codArea" )
	private String codArea;
	
	@Column(name = "codCargo" )
	private String codCargo;
	
	@Column(name = "codEstadoCivil")
	private String codEstadoCivil;*/
	

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



	




	
	
}