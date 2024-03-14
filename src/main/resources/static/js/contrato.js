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





function formatoFecha1(fechaString) {
	var fechaPartida = fechaString.split('-');  			// 2023-12-01
	var anio = fechaPartida[0];
	var mes  = fechaPartida[1];
	var dia  = fechaPartida[2];;
	var fechaFormateada = dia + '/' + mes + '/' + anio;   	// 01/12/2023
	return fechaFormateada;    
}












function fn_obtenerTrabajadorPorDni(idTrabajador) {
    $.ajax({
        url: "http://localhost:8081/planilla/cargarTrabajadorcod/" + idTrabajador,
        type: "GET",
        success: function(respuestaBackend) {
            console.log(respuestaBackend);
            // Aquí puedes usar la información del trabajador
            var nombre = respuestaBackend.nombre;
             var dni = respuestaBackend.dni;
             
           
            // Luego puedes usar esta información como desees, por ejemplo, actualizar elementos HTML
            $("#txtnombreTrabajadorac").val(nombre);
           $("#txtDniTrabajadorac").val(dni);
           
             
           
        },
        error: function() {
            console.error("No es posible completar la operación");
        }
    });
}


 
function fn_listarContrato() {


  
   
	$.ajax({
		url: "http://localhost:8081/planilla/listadoContrato",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#tbody_contrato").empty();
			respuestaBackend.forEach(function(contrato, i) {
				$("#tbody_contrato").append(
					`<tr>
					 <td>${contrato.codContrato}</td>
         <td>${contrato.modContrato}</td>
        <td>${contrato.fechaInicio}</td>
        <td>${contrato.fechaFin}</td>
        <td>${contrato.sueldoBruto}</td>
         <td>${contrato.bonificacion}</td>
        
        
           <td>
              <img title="Eliminar Contrato" src="/img/delete.png" onclick="fn_eliminar(${contrato.codContrato})">
         
              <img title="Actualizar Contrato" src="/img/edit.png" onclick="fn_cargarContratoPorCodigo(${contrato.codContrato})">
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





function formatoFecha(fechaString) {
    var fechaPartida = fechaString.split('/');           
    var anio = fechaPartida[0];
    var mes = fechaPartida[1];
    var dia = fechaPartida[2];
    var fechaFormateada = dia + '-' + mes + '-' + anio;   
    return fechaFormateada;    
}
 
 var trabajadorCodigo
 var codContratoBD; // Declara la variable globalmente para que esté disponible en todo el script

function fn_cargarContratoPorCodigo(codContrato) {
    $("#modalContratoActualizar").show();
    
    $.ajax({
        url: "http://localhost:8081/planilla/obtenerContrato/" + codContrato,
        type: "GET",
        success: function(respuestaBackend) {
            console.log(respuestaBackend);

            var fechaInicioFormateada = formatoFecha(respuestaBackend.fechaInicio);
            var fechaFinFormateada = formatoFecha(respuestaBackend.fechaFin);
            
            $("#txtfechaInicioac").val(fechaInicioFormateada);
            $("#txtfechaFinac").val(fechaFinFormateada);
            
          //   $("#selModalidadac").val(respuestaBackend.modContrato);
             
 var optionPresencial = $("<option>").attr("value", "Presencial").text("Presencial");
var optionHibrida = $("<option>").attr("value", "Híbrida").text("Híbrida");
var optionRemota = $("<option>").attr("value", "Remota").text("Remota");

// Agregar las opciones al combo
$("#selModalidadac").append(optionPresencial, optionHibrida, optionRemota);

// Seleccionar la opción correspondiente a la modalidad del contrato
var modalidadContrato = respuestaBackend.modContrato;
$("#selModalidadac").val(modalidadContrato);
             
            // $("#selEstadoac").val(respuestaBackend.estado);
             
             
             // Crear las opciones "Activo" e "Inactivo"
var optionActivo = $("<option>").attr("value", "Activo").text("Activo");
var optionInactivo = $("<option>").attr("value", "Inactivo").text("Inactivo");

// Agregar las opciones al combo
$("#selEstadoac").append(optionActivo, optionInactivo);

// Seleccionar la opción correspondiente al estado del contrato
var estadoContrato = respuestaBackend.estado;
$("#selEstadoac").val(estadoContrato);
             
             
             
             
             
             
          
               $("#txtBonificacionac").val(respuestaBackend.bonificacion);
          
        
        
            trabajadorCodigo = respuestaBackend.codTrabajador;
            // Realizar acciones con el código del trabajador según sea necesario
           
            fn_obtenerTrabajadorPorDni(trabajadorCodigo);
            
            
           
            var sueldoBruto = respuestaBackend.sueldoBruto.replace(',', '.'); // Reemplazar la coma por un punto
            $("#txtSueldoBrutoac").val(sueldoBruto);
            
            // Guardar el código del contrato en la variable global
            codContratoBD = codContrato;

        },
        error: function() {
            console.error("No es posible completar la operación");
        }
    });
}






function fn_actualizarContrato() {
    // Capturar los valores ingresados en el formulario
    var fechaInicio = $("#txtfechaInicioac").val();
    var fechaFin = $("#txtfechaFinac").val();
     var bonificacionac = $("#txtBonificacionac").val();
  
    var modalidad = $("#selModalidadac").val();
  
    var estado = $("#selEstadoac").val();
  
    var sueldoBruto = $("#txtSueldoBrutoac").val().replace(',', '.');

    // Si el servidor espera fechas en formato dd/mm/yyyy, puedes usar la función formatoFecha para asegurarte de que estén en el formato correcto
    fechaInicio = formatoFecha1(fechaInicio);
    fechaFin = formatoFecha1(fechaFin);

    var objetoContrato = {
        codContrato: codContratoBD, // Utiliza el código del contrato almacenado globalmente
        fechaInicio: fechaInicio,
        fechaFin: fechaFin,
        sueldoBruto: sueldoBruto,
        codTrabajador : trabajadorCodigo,
        modContrato :modalidad,
        bonificacion :bonificacionac,
        estado : estado
        
    };

    $.ajax({
        url: "http://localhost:8081/planilla/actualizarContrato",
        type: "PUT",
        data: JSON.stringify(objetoContrato),
        contentType: "application/json",
        success: function(respuestaBackend) {
            console.log(respuestaBackend);
            $("#modalContrato").hide();
            fn_listarContrato();
        },
        error: function(httpError) {
            console.error("No es posible completar la operación");
            alert("Error al solicitar la petición al servidor: " + httpError);
        }
    });
}





$(document).ready(function() {
    $("#btnIrAOtraPagina").click(function() {
        // Cambiar la ubicación de la página a otra página HTML
       
        window.location.href = "listarContrato.html";
    });
});


 
function fn_visualizarContrato() {


    $("#modalListarContratos").empty();
   
	$.ajax({
		url: "http://localhost:8081/planilla/listadoContrato",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#tablaContratos").empty();
			respuestaBackend.forEach(function(contrato, i) {
				$("#tablaContratos").append(
					`<tr>
					<td>${contrato.codContrato}</td>
                  <td>${contrato.modContrato}</td>
                  <td>${contrato.fechaInicio}</td>
                  <td>${contrato.fechaFin}</td>
                  <td>${contrato.bonificacion}</td>
                  <td>${contrato.sueldoBruto}</td>
                  <td>${contrato.nombreCompletoTrabajador}</td>
                  <td>${contrato.estado}</td>
        
         
          </tr>`
				);
			});
		},
		error: function() {
			console.error("No es posible completar la operación");
		}
	});
}


