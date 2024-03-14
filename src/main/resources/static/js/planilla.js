


function fn_listarContrato() {


	$.ajax({
		url: "http://localhost:8081/planilla/listadoPlanilla",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#tbody_planilla").empty();
			
			respuestaBackend.forEach(function(planilla, i) {
				$("#tbody_planilla").append(
					`<tr>
					 <td>${planilla.codPlanilla}</td>
					 <td>${planilla.descripcion}</td>
                     <td>${planilla.año}</td>
                     <td>${planilla.mes}</td>
                     <td>${planilla.montoTotal}</td>
        
           <td>
              <img title="Eliminar Contrato" src="/img/delete.png" onclick="fn_eliminar(${planilla.codContrato})">
         
              <img title="Actualizar Contrato" src="/img/edit.png" onclick="fn_cargarContratoPorCodigo(${planilla.codContrato})">
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


