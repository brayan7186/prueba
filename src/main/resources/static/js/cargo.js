


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

    console.log(codArea);
    console.log(codCargo);
    console.log(codEstadoCivil);

    $.ajax({
        url: "http://localhost:8081/planilla/buscarTrabajador/" + codArea +"/" + codCargo +"/" + codEstadoCivil,
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
         
              <img title="Actualizar Trabajador" src="img/edit.png" onclick="fn_cargarProductoXCodigo(${trabajador.codTrabajador})">
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





