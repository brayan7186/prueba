


$(document).ready(function() {

   



});

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























//cargar  function de contrato 
 
var codigoTrabajador;

  var sueldoBrutoBD;
  var bonificacionBD;

function fn_cargarTrabajadorPorDni() {

	var dni = document.getElementById("txtDniTrabajador").value;

	if (dni.length == 8) {
		$.ajax({
			url: "http://localhost:8081/planilla/obtenerTrabajadorContrato/" + dni,
			type: "GET",
			success: function(respuestaBackend) {
				console.log(respuestaBackend);
				//$("#txtCodigoProductoAct").val(respuestaBackend.codTrabajador).prop("readonly", true);
				debugger;
				codigoTrabajador = respuestaBackend.codTrabajador;
				
				$("#txtTrabajadorDet").val(respuestaBackend.nombreCompletoTrabajador);
                 $("#txtBonificacionDet").val(respuestaBackend.bonificacion);
                  $("#txtSueldoBrutoDet").val(respuestaBackend.sueldoBruto);
                    bonificacionBD = respuestaBackend.bonificacion;
                     sueldoBrutoBD = respuestaBackend.sueldoBruto
                       calcularDescuentos(sueldoBrutoBD, bonificacionBD);
                        
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






/********************************************************** */

   var descuentoAFP ;
    var descuentoAFP_SEGURURO ;
    var impuestoRenta ;
    var sueldoNeto;
    

function calcularDescuentos(sueldoBrutoBD,bonificacionBD) {
    // Declarar un objeto con las tasas de descuento
          sueldoBrutoBD = parseFloat(sueldoBrutoBD);
    var tasas = {
        AFP: 0.10,
        AFP_SEGURURO: 0.0125,
        IMP_RENTA: 0.10
    };

    // Calcular los descuentos
     descuentoAFP = sueldoBrutoBD * tasas.AFP;
     descuentoAFP_SEGURURO = sueldoBrutoBD * tasas.AFP_SEGURURO;
     impuestoRenta = sueldoBrutoBD * tasas.IMP_RENTA;
     
      var descuentoTotal = descuentoAFP +  descuentoAFP_SEGURURO +  impuestoRenta ;
     
    
     
     sueldoNeto = sueldoBrutoBD - descuentoTotal + bonificacionBD;

    // Imprimir los resultados para depuración
    console.log("Descuento AFP:", descuentoAFP);
    console.log("Descuento AFP SEGURURO:", descuentoAFP_SEGURURO);
    console.log("Impuesto a la Renta:", impuestoRenta);




    // Retornar los descuentos calculados
    /*return {
        descuentoAFP: descuentoAFP,
        descuentoAFP_SEGURURO: descuentoAFP_SEGURURO,
        impuestoRenta: impuestoRenta
    };*/
}

/** */
var totalSueldosNetos = 0;


  function agregarFilaTabla() {
  var tbody = document.getElementById("tbody_registroPlanilla");
  if (tbody.rows.length === 0) {
    Swal.fire({
      title: "Custom width, padding, color, background.",
      width: 600,
      padding: "3em",
      color: "#716add",
      background: "#fff url(/images/trees.png)",
      backdrop: `
        rgba(0,0,123,0.4)
        url("/images/nyan-cat.gif")
        left top
        no-repeat
      `
    });
  } else {
    
    
    
    
    
    
    
  }
}


function agregarFilaTabla() {
	
    var codTrabajador = codigoTrabajador;


    // Obtener la referencia al cuerpo de la tabla
    var tbody = document.getElementById("tbody_registroPlanilla");

    // Crear una nueva fila en la tabla
    var newRow = tbody.insertRow();

    // Insertar celdas en la fila para cada dato
    var codigoTrabajadorCell = newRow.insertCell(0);
    var trabajadorCell = newRow.insertCell(1);
    var sueldoBrutoCell = newRow.insertCell(2);
    var bonificacionCell = newRow.insertCell(3);
    var afpCell = newRow.insertCell(4);
    var afpSeguroCell = newRow.insertCell(5);
    var impuestoRentaCell = newRow.insertCell(6);
    var sueldoNetoCell = newRow.insertCell(7);
    var accionCell = newRow.insertCell(8);

    // Asignar los valores a las celdas
    codigoTrabajadorCell.textContent = codTrabajador;
    trabajadorCell.textContent = $("#txtTrabajadorDet").val();
    sueldoBrutoCell.textContent = $("#txtSueldoBrutoDet").val();
    bonificacionCell.textContent = $("#txtBonificacionDet").val();
    afpCell.textContent = descuentoAFP;
    afpSeguroCell.textContent = descuentoAFP_SEGURURO;
    impuestoRentaCell.textContent = impuestoRenta;
    sueldoNetoCell.textContent = sueldoNeto;

    montototal(sueldoNeto);
    
    
    

    accionCell.innerHTML = '<button class="btn btn-danger btn-eliminar">Eliminar</button>';
    

    // Agregar evento click para eliminar la fila
    accionCell.querySelector('.btn-eliminar').addEventListener('click', function() {
        eliminarFila(this);
    });
}

function eliminarFila(btnEliminar) {
    var fila = btnEliminar.closest("tr");

    // Obtener el valor del sueldo neto de la fila que se va a eliminar
    var sueldoNetoCell = fila.cells[7];
    var sueldoNeto = parseFloat(sueldoNetoCell.textContent);

    // Restar el valor del sueldo neto del totalSueldosNetos
    totalSueldosNetos -= sueldoNeto;

    // Eliminar la fila
    fila.parentNode.removeChild(fila);

    // Actualizar el valor del monto total en el input
    document.getElementById("txtMontoTotalPlanilla").value = totalSueldosNetos;
}

function montototal(sueldoNeto)

{
 
    totalSueldosNetos += parseFloat(sueldoNeto);
    document.getElementById("txtMontoTotalPlanilla").value = totalSueldosNetos;
}


	
	
	 

function abrirModal() {
    $("#modalAgregarPlanilla").modal("show");
}



function abrirModalDetalle() {
    $("#modalAgregarDetalle").modal("show");
}


function fn_registrarContrato() {
    // Obtener el número de filas con datos en la tabla
    var rowCount = $("#tbody_registroPlanilla tr").length;
    // Verificar si hay al menos dos filas con datos
    if (rowCount < 2) {
        // Mostrar un mensaje de advertencia con SweetAlert2
        Swal.fire({
            icon: 'warning',
            title: 'Advertencia',
            text: 'Debe haber al menos dos registros en la tabla.',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'Entendido'
        });
        return; // Detener la ejecución de la función si no hay suficientes filas
    }

    // Obtener los valores de los campos del contrato
    var anio = $("#selectAnio").val();
    var mes = $("#selectMes").val();
    var descripcion = $("#txtdescripcion").val();
    var montoTotal = $("#txtMontoTotal").val();
    var dni = $("#txtDniTrabajador").val();
    var nombre = $("#txtTrabajador").val();
    var bonificacion = $("#txtBonificacion").val();
    var sueldoBruto = $("#txtSueldoBruto").val();
    var diaNoLaborado = $("#txtDiasNoLaborado").val();
    var descuentotoAfp = $("#txtDescuentoAfp").val();
    var descuentoHora = $("#txtDescuentoPorHoras").val();
    var descuentoAfpSeguro = $("#txtDescuentoAfpSeguro").val();
    var cantidadDeHorasTardanzas = $("#txtCantidadDeHorasTardanza").val();

    // Crear un objeto con los datos del contrato
    var planilla = {
        anio: anio,
        mes: mes,
        nombre: descripcion,
        detalle: [{
            bonificacion: bonificacion,
            sueldoBruto: sueldoBruto,
            diaNoLaborado: diaNoLaborado,
            cantidadHoraTardanza: cantidadDeHorasTardanzas,
            codTrabajador: 5068 // No se proporciona el código del trabajador en este código, asegúrate de ajustarlo según tus necesidades
        }]
    };

    // Realizar la petición AJAX para registrar el contrato
    $.ajax({
        url: "http://localhost:8081/planilla/crearContrato",
        type: "POST",
        data: JSON.stringify(planilla),
        contentType: "application/json",
        success: function(respuestaBackend) {
            console.log(respuestaBackend);
            // Mostrar un mensaje de éxito con SweetAlert2
            Swal.fire({
                icon: 'success',
                title: '¡Registro exitoso!',
                text: 'El contrato se ha creado correctamente.'
            }).then(() => {
                // Limpiar los campos después de la confirmación de éxito
                limpiarCampos();
            });
        },
        error: function() {
            console.error("No es posible completar la operación");
        }
    });
}

// Función para limpiar los campos después del registro exitoso
function limpiarCampos() {
    $("#selectAnio").val("");
    $("#selectMes").val("");
    $("#txtdescripcion").val("");
    $("#txtMontoTotal").val("");
    $("#txtDniTrabajador").val("");
    $("#txtTrabajador").val("");
    $("#txtBonificacion").val("");
    $("#txtSueldoBruto").val("");
    $("#txtDiasNoLaborado").val("");
    $("#txtDescuentoAfp").val("");
    $("#txtDescuentoPorHoras").val("");
    $("#txtDescuentoAfpSeguro").val("");
    $("#txtCantidadDeHorasTardanza").val("");
}




	


 

 