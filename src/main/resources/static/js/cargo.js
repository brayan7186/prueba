


$(document).ready(function() {

    fn_listarTipoDistritoJquery();
	fn_listarTipoEstadoCivilJquery();
	fn_listarTipoAreaJquery();

	fn_buscarTrabajadorJquery();



	var selectUser = document.querySelector("[name='selArea']");

	selectUser.addEventListener("change", (e) => {

		var codArea = selectUser.options[selectUser.selectedIndex].value;
		fn_listarTipoCargoJquery(codArea);
	});



});





function fn_listarTipoCargoJquery(codArea) {
	/* http://localhost:8081/planilla/listadoCargoPorArea*/
	$.ajax({
		url: "http://localhost:8081/planilla/listadoCargoPorArea/" + codArea,
		type: "GET",
		success: function(respuestaBackend) {  
			console.log(respuestaBackend);
			$("#selEstadoCargo").empty();
			if (respuestaBackend.length > 0) {
				respuestaBackend.forEach(function(tipoCargo, i) {
					$("#selEstadoCargo").append(`<option value="${tipoCargo.codCargo}">${tipoCargo.descripcion}</option>`);
				});
			}
		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}



/**Estado civil*/
function fn_listarTipoEstadoCivilJquery() {
	$.ajax({

		url: "http://localhost:8081/planilla/listadoEstadoCivil",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selEstadoCivil").empty();


			if (respuestaBackend.length > 0) {

				respuestaBackend.forEach(function(tipoEstadoCivil, i) {

					$("#selEstadoCivil").append(`<option value="${tipoEstadoCivil.codEstCivil}">${tipoEstadoCivil.descripcion}</option>`);



				});
			}


		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}



/**Area*/
function fn_listarTipoAreaJquery() {
	$.ajax({

		url: "http://localhost:8081/planilla/listadoArea",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selEstadoArea").empty();

			if (respuestaBackend.length > 0) {

				respuestaBackend.forEach(function(tipoEstadoCivil, i) {

					$("#selEstadoArea").append(`<option value="${tipoEstadoCivil.codArea}">${tipoEstadoCivil.descripcion}</option>`);



				});
			}


		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}




/**Area*/
function fn_listarTipoDistritoJquery() {
	$.ajax({

		url: "http://localhost:8081/planilla/listadoDistrito",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selDistrito").empty();

			if (respuestaBackend.length > 0) {

				respuestaBackend.forEach(function(tipoDistrito, i) {

					$("#selDistrito").append(`<option value="${tipoDistrito.codDistrito}">${tipoDistrito.descripcion}</option>`);



				});
			}


		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}


















/**Estado civil*/
function fn_listarTipoEstadoCivilEditar(codigoEstadoCivilBD) {


	$.ajax({

		url: "http://localhost:8081/planilla/listadoEstadoCivil",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selEstadoCivilEditar").empty();


			if (respuestaBackend.length > 0) {

				respuestaBackend.forEach(function(tipoEstadoCivil, i) {

					$("#selEstadoCivilEditar")
						.append(`<option value="${tipoEstadoCivil.codEstCivil}">${tipoEstadoCivil.descripcion}</option>`);

					if (tipoEstadoCivil.codEstCivil == codigoEstadoCivilBD) {
						// Establece el atributo selected
						$("#selEstadoCivilEditar option[value='" + tipoEstadoCivil.codEstCivil + "']").prop("selected", true);
					}
				});
			}
		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}



/**Area*/
function fn_listarTipoAreaEditar(codigoAreBD) {
	$.ajax({

		url: "http://localhost:8081/planilla/listadoArea",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selEstadoAreaEditar").empty();

			if (respuestaBackend.length > 0) {

				respuestaBackend.forEach(function(tipoEstadoCivil, i) {

					$("#selEstadoAreaEditar")
						.append(`<option value="${tipoEstadoCivil.codArea}">${tipoEstadoCivil.descripcion}</option>`);


					if (tipoEstadoCivil.codArea == codigoAreBD) {
						// Establece el atributo selected
						$("#selEstadoAreaEditar option[value='" + tipoEstadoCivil.codArea + "']").prop("selected", true);
					}

				});
			}


		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}



function fn_listarTipoCargoEditar(codigoAreBD, codigoCargoBD) {
	/* http://localhost:8081/planilla/listadoCargoPorArea*/
	$.ajax({
		url: "http://localhost:8081/planilla/listadoCargoPorArea/" + codigoAreBD,
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selEstadoCargoEditar").empty();
			if (respuestaBackend.length > 0) {
				respuestaBackend.forEach(function(tipoCargo, i) {


					$("#selEstadoCargoEditar").append(`<option value="${tipoCargo.codCargo}">${tipoCargo.descripcion}</option>`);


					if (tipoCargo.codCargo == codigoCargoBD) {
						// Establece el atributo selected
						$("#selEstadoCargoEditar option[value='" + tipoCargo.codCargo + "']").prop("selected", true);
					}

				});
			}
		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}

/********************************************** */



/**  listar trabajadro por codigo area codigo cargo codgio estadoCivil */



/*USANDO JQUERY */
function fn_buscarTrabajadorJquery() {

	var codArea = $("#selEstadoArea").val();
	var codCargo = $("#selEstadoCargo").val();
	var codEstadoCivil = $("#selEstadoCivil").val();
	
    var distrito = $("#selDistrito").val();
    
	console.log(codEstadoCivil);

	console.log(codArea);
	console.log(codCargo);

  console.log(distrito);
  
	$.ajax({
		url: "http://localhost:8081/planilla/buscarTrabajador/" + codArea + "/" + codCargo + "/" + codEstadoCivil +"/"+ distrito ,
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#tbody_trabajador").empty();
			respuestaBackend.forEach(function(trabajador, i) {
				$("#tbody_trabajador").append(
					`<tr>
             <td>${trabajador.codTrabajador}</td>
        <td>${trabajador.nombre}</td>
        <td>${trabajador.correo}</td>
        <td>${trabajador.distrito}</td>
        <td>${trabajador.dni}</td>
        <td>${trabajador.descripcionArea}</td>
        <td>${trabajador.descripcionCargo}</td>
        <td>${trabajador.descripcionEstadoCivil}</td>
        
           <td>
              <img title="Eliminar Trabajdor" src="img/delete.png" onclick="fn_eliminar(${trabajador.codTrabajador})">
         
              <img title="Actualizar Trabajador" src="img/edit.png" onclick="fn_cargarTrabajadorPorCodigo(${trabajador.codTrabajador})">
            </td>
          </tr>`
				);
			});
		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}



/** funcion para elimis trabajador  */
function fn_eliminar(codTrabajador) {

	console.log(codTrabajador);
	$.ajax({
		url: "http://localhost:8081/planilla/eliminarTrabajador/" + codTrabajador,
		type: "DELETE",
		success: function(respuestaBackend) {
			alert(respuestaBackend.MENSAJE);
			fn_buscarTrabajadorJquery();
		},
		error: function(httpError) {
			console.error("No es posible completar la operación");
			alert("Error al solicitar la petición al servidor  : " + httpError);
		}
	});
}



    var codigoEstadoCivilBD;
	var codigoCargoBD;
	var codigoAreBD;
	var codTrabajadorBD;
	
function fn_cargarTrabajadorPorCodigo(codTrabajador) {

	$("#modalTrabajador").show();


	$.ajax({
		url: "http://localhost:8081/planilla/obtenerDatosTrabajador/" + codTrabajador,
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);

			//$("#txtCodigoProductoAct").val(respuestaBackend.codTrabajador).prop("readonly", true);

			$("#txtNombreTrabajador").val(respuestaBackend.nombre);
			$("#txtApePaternoTrabajador").val(respuestaBackend.apePaterno);
			$("#txtApeMaternoTrabajador").val(respuestaBackend.apeMaterno);
			$("#txtEdadTrabajador").val(respuestaBackend.edad);
			$("#txtDniTrabajador").val(respuestaBackend.dni);
			$("#txtCelularTrabajador").val(respuestaBackend.celular);
			$("#txtCorreoTrabajador").val(respuestaBackend.correo);
			$("#txtDireccionTrabajador").val(respuestaBackend.distrito);
			debugger;
			codigoEstadoCivilBD = respuestaBackend.codEstadoCivil;
			codigoAreBD = respuestaBackend.codArea
			codigoCargoBD = respuestaBackend.codCargo;
			
            codTrabajadorBD  = codTrabajador;
            
			console.log("este cogidigo  estado civil BD" + codigoEstadoCivilBD);

			fn_listarTipoEstadoCivilEditar(codigoEstadoCivilBD);
			fn_listarTipoAreaEditar(codigoAreBD);
			fn_listarTipoCargoEditar(codigoAreBD, codigoCargoBD);
		
		
		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});


}
	// Llenar los combos con los datos obtenidos


//tipo  de  dsitrito  escogido  


 //actualizar  trabajador 

 function fn_actualizarTrabajador() {
  // Capturar los valores ingresados en el formulario
 
 
  // var codTrabajador = $("#txtCodTrabajador").val();
   var nombre  =$("#txtNombreTrabajador").val();
   var apePaterno  =$("#txtApePaternoTrabajador").val();
   var apeMaterno  =$("#txtApeMaternoTrabajador").val();
   var edad  =$("#txtEdadTrabajador").val();
   
   var dni  =$("#txtDniTrabajador").val();
   var celular  =$("#txtCelularTrabajador").val();
   
   var correo  =$("#txtCorreoTrabajador").val();
   var distrito  =$("#txtDireccionTrabajador").val();
   
   var estadoAres  =$("#selEstadoAreaEditar").val();
   var estadoCargo  =$("#selEstadoCargoEditar").val();
   var estadoCivil  =$("#selEstadoCivilEditar").val();
 
     

  var objetoTrabajador = {
   
      codTrabajador : codTrabajadorBD,
     nombre : nombre,
     apeMaterno :apeMaterno ,
     apePaterno :apePaterno,
     celular : celular,
	 correo : correo,
	 distrito : distrito,
	 dni : dni,
     edad : edad,
     codArea :estadoAres,
	 codCargo : estadoCargo, 
     codEstCivil : estadoCivil
  };

  $.ajax({
	
    url:"http://localhost:8081/planilla/actualizarTrabajador",
    type:"PUT",
    //  DE  
    data:JSON.stringify(objetoTrabajador),
    contentType:"application/json",
    success: function(respuestaBackend) {
      console.log(respuestaBackend);
      $("#modalTrabajador").hide();
      fn_buscarTrabajadorJquery(); // función para actualizar la lista de productos después de la actualización
    },
   
   
    error: function(httpError) {
      console.error("No es posible completar la operación");
      alert("Error al solicitar la petición al servidor: " + httpError);
    }
  });
}


/* registrar producto    inicio*/



	var codAre;
	var codCargo;
	var codEstadoCivil;
	
 function fn_abrir() {
	
	
	
    $("#modalCrearTrabajador").show();
    
      $('#txtNombreTrabajadorc').focus();
     fn_listarTipoDistritoCrear();
    fn_listarTipoEstadoCivilCrear();
   
    fn_listarTipoAreaCrear();

    // Asegúrate de que el área se haya cargado antes de llamar a la función para cargar los cargos
    $("#selEstadoAreac").on("change", function() {
         codArea = $(this).val();
        fn_listarTipoCargoCrear(codArea);
    });
    
}


  

 function fn_crearTrabajador() {

	
	
	 
  // CAPTURAR LOS VALORES INGRESADOS EN EL FORMULARIO
  var nombre = $("#txtNombreTrabajadorc").val();
  var apePaterno = $("#txtApePaternoTrabajadorc").val();
  var apeMaterno = $("#txtApeMaternoTrabajadorc").val();
  var edad = $("#txtEdadTrabajadorc").val();
  var dni = $("#txtDniTrabajadorc").val();
  var celular = $("#txtCelularTrabajadorc").val();
  var correo = $("#txtCorreoTrabajadorc").val();
  var direccion = $("#txtDireccionTrabajadorc").val();
  var codEstadoCivil = $("#selEstadoCivilc").val();
  var codCargo = $("#selEstadoCargoc").val();
  var codArea = $("#selEstadoAreac").val();
  var codDistrito = $("#selDistritoc").val();
  
  
  
  // CREAR UN OBJETO CON JAVASCRIPT
  var objetoTrabajador = {
    nombre: nombre,
    apePaterno: apePaterno,
    apeMaterno: apeMaterno,
    edad: edad,
    dni: dni,
    celular: celular,
    correo: correo,
    direccion: direccion,
    codEstCivil: codEstadoCivil,
    codCargo: codCargo,
    codArea: codArea,
    codDistrito :codDistrito
  };

  $.ajax({
    url: "http://localhost:8081/planilla/crearTrabajador",
    type: "POST",
    data: JSON.stringify(objetoTrabajador),
    contentType: "application/json",
    success: function(respuestaBackend) {
      console.log(respuestaBackend);
      $("#modalTrabajador").hide();
      alert(respuestaBackend.respuesta);
    },
    error: function() {
      console.error("No es posible completar la operación");
    }
  });
}


/**Estado civil*/
function fn_listarTipoEstadoCivilCrear() {
	$.ajax({

		url: "http://localhost:8081/planilla/listadoEstadoCivil",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selEstadoCivilc").empty();


			if (respuestaBackend.length > 0) {

				respuestaBackend.forEach(function(tipoEstadoCivil, i) {

					$("#selEstadoCivilc").append(`<option value="${tipoEstadoCivil.codEstCivil}">${tipoEstadoCivil.descripcion}</option>`);



				});
			}


		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}




/** */
function fn_listarTipoCargoCrear(codArea) {
	/* http://localhost:8081/planilla/listadoCargoPorArea*/
	$.ajax({
		url: "http://localhost:8081/planilla/listadoCargoPorArea/" + codArea,
		type: "GET",
		success: function(respuestaBackend) {  
			console.log(respuestaBackend);
			$("#selEstadoCargoc").empty();
			if (respuestaBackend.length > 0) {
				respuestaBackend.forEach(function(tipoCargo, i) {
					$("#selEstadoCargoc").append(`<option value="${tipoCargo.codCargo}">${tipoCargo.descripcion}</option>`);
				});
			}
		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}




/**Area*/
function fn_listarTipoAreaCrear() {
	$.ajax({

		url: "http://localhost:8081/planilla/listadoArea",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selEstadoAreac").empty();

			if (respuestaBackend.length > 0) {

				respuestaBackend.forEach(function(tipoEstadoCivil, i) {

					$("#selEstadoAreac").append(`<option value="${tipoEstadoCivil.codArea}">${tipoEstadoCivil.descripcion}</option>`);



				});
			}


		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}



function fn_listarTipoDistritoCrear() {
	$.ajax({

		url: "http://localhost:8081/planilla/listadoDistrito",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selDistritoc").empty();


			if (respuestaBackend.length > 0) {

				respuestaBackend.forEach(function(tipoDistrito, i) {

					$("#selDistritoc").append(`<option value="${tipoDistrito.codDistrito}">${tipoDistrito.descripcion}</option>`);



				});
			}


		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}



