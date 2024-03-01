


$(document).ready(function() {


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


/**  listar trabajadro por codigo area codigo cargo codgio estadoCivil */



/*USANDO JQUERY */
function fn_buscarTrabajadorJquery() {

	var codArea = $("#selEstadoArea").val();
	var codCargo = $("#selEstadoCargo").val();
	var codEstadoCivil = $("#selEstadoCivil").val();

	console.log(codEstadoCivil);

	console.log(codArea);
	console.log(codCargo);


	$.ajax({
		url: "http://localhost:8081/planilla/buscarTrabajador/" + codArea + "/" + codCargo + "/" + codEstadoCivil,
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



function fn_cargarTrabajadorPorCodigo(codTrabajador) {

	$("#modalTrabajador").show();


	// Obtener los elementos select después de obtener la respuesta del servidor
	var selectArea = document.getElementById("selEstadoArea");
	var selectCargo = document.getElementById("selEstadoCargo");
	var selectEstadoCivil = document.getElementById("selEstadoCivil");

	// Obtener los valores seleccionados
	var valorArea = selectArea.value;
	var valorCargo = selectCargo.value;
	var valorEstadoCivil = selectEstadoCivil.value;

	// Hacer algo con los valores seleccionados, como mostrarlos en la consola
	console.log("Área seleccionada:", valorArea);
	console.log("Cargo seleccionado:", valorCargo);
	console.log("Estado Civil seleccionado:", valorEstadoCivil);


	var codigoEstadoCivilBD;
	var codigoCargoBD;
	var codigoAreBD;

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
			$("#txtDireccionTrabajador").val(respuestaBackend.direccion);
			debugger;
			codigoEstadoCivilBD = respuestaBackend.codEstadoCivil;
			codigoAreBD = respuestaBackend.codArea
			codigoCargoBD = respuestaBackend.codCargo;

			console.log("este cogidigo  estado civil BD" + codigoEstadoCivilBD);

			fn_listarTipoEstadoCivilEditar(codigoEstadoCivilBD);
			fn_listarTipoAreaEditar(codigoAreBD);
			fn_listarTipoCargoEditar(codigoAreBD, codigoCargoBD);
		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});

	// Llenar los combos con los datos obtenidos






}


