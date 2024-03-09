$(document).ready(function() {

    


});







   function fn_abrirModalRegistrarContrato() {
	
    $("#modalContrato").show();
    

}


 function fn_registrarContrato() {
	
	
   var modalidad = document.getElementById("selModalidad").value;
    var fechaInicio = document.getElementById("txtFechaInicio").value;
    var fechaFin = document.getElementById("txtFechaFin").value;
    var sueldoBruto = document.getElementById("txtSueldoBruto").value;
    var bonificacion = document.getElementById("txtBonificacion").value;
    
    var dni  = document.getElementById("txtDNITrabajador").value;
   
    // Validar que todos los campos estén completos
    if (modalidad === "" || fechaInicio === "" || fechaFin === "" || sueldoBruto === "" || bonificacion === "" ) {
        alert("Por favor, complete todos los campos.");
        return;
    }

    // Crear un objeto con los datos del contrato
    var contrato = {
        modalidad: modalidad,
        fechaInicio: fechaInicio,
        fechaFin: fechaFin,
        sueldoBruto: parseFloat(sueldoBruto),
        bonificacion: parseFloat(bonificacion),
      
    };  
    $.ajax({
                url: "http://localhost:8081/planilla/crearTrabajador",
                type: "POST",
                data: JSON.stringify(contrato),
                contentType: "application/json",
                success: function(respuestaBackend) {
                    console.log(respuestaBackend);
                
                    $("#modalTrabajador").hide();
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

  