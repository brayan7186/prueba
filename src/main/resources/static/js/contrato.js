$(document).ready(function() {




});







function fn_abrirModalRegistrarContrato() {

	$("#modalContrato").show();


}



var codigoTrabajador;

function fn_cargarTrabajadorPorDni() {

	var dni = document.getElementById("txtDinTrabajador").value;

	if (dni.length == 8) {
		$.ajax({
			url: "http://localhost:8081/planilla/obtenerTrabajadorPorDni/" + dni,
			type: "GET",
			success: function(respuestaBackend) {
				console.log(respuestaBackend);
				//$("#txtCodigoProductoAct").val(respuestaBackend.codTrabajador).prop("readonly", true);
				debugger;
				codigoTrabajador = respuestaBackend.codTrabajador;
				$("#txtnombreTrabajador").val(respuestaBackend.nombre);



			},
			error: function() {
				console.error("No es posible completar la operación");
			}
		});
	}
	else {
		$("#txtnombreTrabajador").val("");
	}
}





function fn_registrarContrato() {


	var modalidad = document.getElementById("selModalidad").value;
	var fechaInicio = document.getElementById("txtFechaInicio").value;
	var fechaFin = document.getElementById("txtFechaFin").value;
	var sueldoBruto = document.getElementById("txtSueldoBruto").value;
	var bonificacion = document.getElementById("txtBonificacion").value;

	var cod = codigoTrabajador;
	// var dni  = document.getElementById("txtnombreTrabajador").value;




	// Validar que todos los campos estén completos
	if (modalidad === "" || fechaInicio === "" || fechaFin === "" || sueldoBruto === "" || bonificacion === "") {
		alert("Por favor, complete todos los campos.");
		return;
	}

	var fechaInicioFormateado = formatoFecha(fechaInicio);
	var fechaFinformateado = formatoFecha(fechaFin);


	// Crear un objeto con los datos del contrato
	var contrato = {
		modContrato: modalidad,
		fechaInicio: fechaInicioFormateado,
		fechaFin: fechaFinformateado,
		sueldoBruto: sueldoBruto,
		bonificacion: bonificacion,
		codTrabajador: cod
	};
	$.ajax({
		url: "http://localhost:8081/planilla/crearContrato",
		type: "POST",
		data: JSON.stringify(contrato),
		contentType: "application/json",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);

			// $("#modalTrabajador").hide();
			Swal.fire({
				icon: 'success',
				title: '¡Registro exitoso!',
				text: 'El contrato se ha creado correctamente.'
			}).then(() => {
				// Limpiar los campos después de la confirmación de éxito
				$("#selModalidad").val("");
				$("#txtFechaInicio").val("");
				$("#txtFechaFin").val("");
				$("#txtSueldoBruto").val("");
				$("#txtBonificacion").val("");

				$("#txtCelularTrabajadorc").val("");

			});
		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}





function formatoFecha(fechaString) {
	var fechaPartida = fechaString.split('-');  			// 2023-12-01
	var anio = fechaPartida[0];
	var mes  = fechaPartida[1];
	var dia  = fechaPartida[2];;
	var fechaFormateada = dia + '/' + mes + '/' + anio;   	// 01/12/2023
	return fechaFormateada;    
}















function fn_listarTrabajadorPorDni(codigoAreBD) {
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

