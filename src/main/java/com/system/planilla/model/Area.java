package com.system.planilla.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_AREA")
@Setter
@Getter
@NoArgsConstructor
public class Area {
	
	@Id
	@Column(name = "codArea")
	 private Integer codArea;
	
	@Column(name = "descripcion"  ,length = 50)
	private String descripcion;

	
	
	
	
	
	
	public Area(Integer codArea2) {
		
		  this.codArea = codArea2;
	}

	@Override
	public String toString() {
		return "Area [codArea=" + codArea + ", descripcion=" + descripcion + "]";
	}




	public Integer getCodArea() {
		return codArea;
	}

	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
