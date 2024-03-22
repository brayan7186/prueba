


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
				
				
				  
				codigoTrabajador = respuestaBackend.codTrabajador;
				
				$("#txtTrabajadorDet").val(respuestaBackend.nombreCompletoTrabajador);
                 $("#txtBonificacionDet").val(respuestaBackend.bonificacion);
                  $("#txtSueldoBrutoDet").val(respuestaBackend.sueldoBruto);
                  
                   if (respuestaBackend.bonificacion == null || respuestaBackend.sueldoBruto == null) {
                    Swal.fire({
                        icon: 'error',
                        title: '¡Uy!',
                        text: 'el trabajador  con dni :'+dni+'   aun no tiene contrato'
                    });
                    
                     limpiarCapos();
                } else {
                    // Si no son nulos, calcular descuentos y realizar otras operaciones
                    bonificacionBD = respuestaBackend.bonificacion;
                    sueldoBrutoBD = respuestaBackend.sueldoBruto;
                    calcularDescuentos(sueldoBrutoBD, bonificacionBD);
                }
                        
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

/**  */
var totalSueldosNetos = 0;
var codTrabajador;
  
  function agregarFilaTabla() {
	
	  
    var codTrabajador = codigoTrabajador;
    var existe = false;

    // Verificar si el código del trabajador ya existe en la tabla
    var tabla = document.getElementById("tbody_registroPlanilla");
    for (var i = 0, row; row = tabla.rows[i]; i++) {
        if (row.cells[0].textContent == codTrabajador) {
            existe = true;
            break;
        }
    }


    // Si el código del trabajador no existe en la tabla, agregarlo
    if (!existe) {
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

        // Limpiar los campos
        limpiarCapos();
    } else {
	
	  Swal.fire({
  title: '¡Uy!',
  text: 'El trabajador '  +$("#txtTrabajadorDet").val() +'con código ya está registrado en la tabla.',
  icon: 'warning',
  confirmButtonText: 'Cool',
  backdrop: false
})
       
    }
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


	
	
	 
   function obtenerNombreMes(numeroMes) {
		
    var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    return meses[numeroMes];
}

	function mesActual(){
		     
      var mesActual = new Date().getMonth();

// Obtener el nombre del mes actual
var nombreMesActual = obtenerNombreMes(mesActual);

// Iterar sobre las opciones del combo de selección de mes
$("#selectMes option").each(function() {
    // Comprobar si el valor de la opción coincide con el mes actual
    if ($(this).val() === nombreMesActual) {
        // Seleccionar esta opción si coincide con el mes actual
        $(this).prop("selected", true);
    }
});

		
	} 
	 
	 
	 function  obtenerAnioActual(){
		
		 var anioActual = new Date().getFullYear();

       // Asignar el año actual al campo de entrada de texto
     $("#txtAnio").val(anioActual);
	}
	 
	 
	 
	 

 function abrirModal() {
	
    $("#modalAgregarPlanilla").modal("show");
         
      
      mesActual();
 obtenerAnioActual();

 

 }

   //
  // Función para obtener el nombre del mes a partir de su número (0 para enero, 1 para febrero, etc.)
//FALTA
function limpiarCapos(){
	
	  

   $("#txtDniTrabajador").val("");
    $("#txtTrabajadorDet").val("");
     $("#txtBonificacionDet").val("");
      $("#txtSueldoBrutoDet").val("");
      
    
}

function abrirModalDetalle() {
    $("#modalAgregarDetalle").modal("show");
    
}








// Función para limpiar los campos después del registro exitoso
function limpiarCampos() {
    $("#selectAnio").val("");
    $("#selectMes").val("");
    
}

/* ******************************************** */


function fn_registrarPlanilla() {
	
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
    
      
       var anio = $("#selectAnio").val();
       var mes = $("#selectMes").val();
         
       var descripcion = $("#txtdescripcion").val();
    
   
     var detallesPlanilla = [];


      //Básicamente, esta parte del código recorre cada fila de la tabla de registro de la planilla
     //  (#tbody_registroPlanilla tr) y busca en cada fila el código del trabajador, 
    //el sueldo bruto y la bonificación, extrayendo estos valores de las celdas correspondientes.
   // Iterar sobre las filas de la tabla y obtener los valores de cada detalle
    $("#tbody_registroPlanilla tr").each(function() {
       
        codTrabajador = $(this).find("td:eq(0)").text();
        var sueldoBruto = $(this).find("td:eq(2)").text();
        var bonificacion = $(this).find("td:eq(3)").text();
  
         
         //var montoTotal = $("#txtMontoTotalPlanilla").val();
        // var bonificacion = $("#txtBonificacionDet").val();
       // var sueldoBruto = $("#txtSueldoBrutoDet").val();
  
     //var cod =+codTrabajador ;
      
   // Crear un objeto con los datos del detalle de la planilla
        var detalle = {
            sueldoBruto: parseFloat(sueldoBruto),    // Convertir a número
            bonificacion: parseFloat(bonificacion), // Convertir a número
            codTrabajador: parseInt(codTrabajador) // Convertir a número entero
        };
         // se agrega al array de detallesPlanilla el  objeto detalle
        // push : 	metodo que sirve para  agregar un objeto a un  array
        detallesPlanilla.push(detalle);
        
    });

    // Crear el objeto de la planilla con los datos recopilados
    var planilla = {
        nombre: descripcion,
        anio: anio, // Convertir a número entero
        mes: mes,
        detalle: detallesPlanilla
    };

    // Realizar la petición AJAX para registrar la planilla
    $.ajax({
        url: "http://localhost:8081/planilla/crearPlanilla",
        type: "POST",
        data: JSON.stringify(planilla),
        contentType: "application/json",
        success: function(respuestaBackend) {
            console.log(respuestaBackend);
            
           Swal.fire({
                icon: 'success',
                title: '¡Registro exitoso!',
                text: 'La planilla se ha registrado correctamente.'
            }).then(() => {
                // Limpiar los campos después de la confirmación de éxito
                limpiarCampos();
            });
        },
        error: function() {
            console.error("No es posible completar la operación");
             // Mostrar un mensaje de error al usuario
            alert('Se produjo un error al registrar la planilla. Por favor, inténtalo de nuevo.');
        }
    });
    
}


  