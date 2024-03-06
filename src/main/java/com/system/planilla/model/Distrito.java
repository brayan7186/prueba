package com.system.planilla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "TB_DISTRITO")
@Getter
@Setter
@AllArgsConstructor
public class Distrito {
	
	

		
		@Id
		@Column(name = "codDistrito")
		private Integer codDistrito;
		
		
		

		@Column(name = "descripcion" , length = 50)
		private String descripcion;




		public Distrito(Integer codDistrito) {
			super();
			this.codDistrito = codDistrito;
		}




		public Distrito() {
			super();
		}

		


}
