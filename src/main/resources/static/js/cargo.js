

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


function fn_listarTipoDistritoEditar(codDistritoBD) {


	$.ajax({

		url: "http://localhost:8081/planilla/listadoDistrito",
		type: "GET",
		success: function(respuestaBackend) {
			console.log(respuestaBackend);
			$("#selDistritoEditar").empty();


			if (respuestaBackend.length > 0) {

				respuestaBackend.forEach(function(tipoDistrito, i) {

					$("#selDistritoEditar")
						.append(`<option value="${tipoDistrito.codDistrito}">${tipoDistrito.descripcion}</option>`);

					if (tipoDistrito.codDistrito == codDistritoBD) {
						// Establece el atributo selected
						$("#selDistritoEditar option[value='" + tipoDistrito.codDistrito + "']").prop("selected", true);
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
	
    var codDistrito = $("#selDistrito").val();
    
	console.log(codEstadoCivil);

	console.log(codArea);
	console.log(codCargo);

  console.log(codDistrito);
  
	$.ajax({
		url: "http://localhost:8081/planilla/buscarTrabajador/" + codArea + "/" + codCargo + "/" + codEstadoCivil +"/"+ codDistrito ,
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
        <td>${trabajador.descripcionDistrito}</td>
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
	var codDistritoBD;
	
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
			$("#txtDireccionTrabajador").val(respuestaBackend.direccion);
			debugger;
			codigoEstadoCivilBD = respuestaBackend.codEstadoCivil;
			codigoAreBD = respuestaBackend.codArea;
			codigoCargoBD = respuestaBackend.codCargo;
			codDistritoBD = respuestaBackend.codDistrito;
            codTrabajadorBD  = codTrabajador;
            
			console.log("este cogidigo  estado civil BD" + codigoEstadoCivilBD);

			fn_listarTipoEstadoCivilEditar(codigoEstadoCivilBD);
			fn_listarTipoAreaEditar(codigoAreBD);
			fn_listarTipoCargoEditar(codigoAreBD, codigoCargoBD);
		    fn_listarTipoDistritoEditar(codDistritoBD);
		
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
   var direccion  =$("#txtDireccionTrabajador").val();
   
   var estadoAres  =$("#selEstadoAreaEditar").val();
   var estadoCargo  =$("#selEstadoCargoEditar").val();
   var estadoCivil  =$("#selEstadoCivilEditar").val();
    var estadoDistrito  =$("#selDistritoEditar").val();
 
    
 
     

  var objetoTrabajador = {
   
      codTrabajador : codTrabajadorBD,
     nombre : nombre,
     apeMaterno :apeMaterno ,
     apePaterno :apePaterno,
     celular : celular,
	 correo : correo,
	 direccion : direccion,
	 dni : dni,
     edad : edad,
     codArea :estadoAres,
	 codCargo : estadoCargo, 
     codEstCivil : estadoCivil,
     codDistrito : estadoDistrito
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
      fn_buscarTrabajadorJquery();
     // función para actualizar la lista de productos después de la actualización
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


  
   function validarCorreo(correo) {
    // Expresión regular para validar el formato del correo electrónico
    var regex = /^[a-zA-Z0-9._%+-]+@(gmail|hotmail)\.com$/;

    // Verificar si el correo cumple con el formato permitido
    return regex.test(correo);
}

function fn_crearTrabajador() {
    var campos = [
        { id: "#txtNombreTrabajadorc", mensaje: "Nombre" },
        { id: "#txtApePaternoTrabajadorc", mensaje: "Apellido Paterno" },
        { id: "#txtApeMaternoTrabajadorc", mensaje: "Apellido Materno" },
        { id: "#txtDniTrabajadorc", mensaje: "DNI" },
        { id: "#txtEdadTrabajadorc", mensaje: "Edad" },
        { id: "#txtCelularTrabajadorc", mensaje: "Celular" },
        { id: "#txtCorreoTrabajadorc", mensaje: "Correo" },
        { id: "#selEstadoCivilc", mensaje: "Estado Civil" },
        { id: "#selEstadoAreac", mensaje: "Área" },
        { id: "#selEstadoCargoc", mensaje: "Cargo" },
        { id: "#selDistritoc", mensaje: "Distrito" }
    ];

    var camposFaltantes = [];

    for (var i = 0; i < campos.length; i++) {
        var campo = campos[i];
        var valor = $(campo.id).val();
        if (valor === "" || valor === null) {
            camposFaltantes.push(campo.mensaje); // Agregar mensaje al array de campos faltantes
            $(campo.id).focus(); // Dar foco al campo vacío
        }
    }

    if (camposFaltantes.length > 0) {
        var mensajeAlerta = "<div style='text-align:left'>";
        for (var j = 0; j < camposFaltantes.length; j++) {
            mensajeAlerta += j+1 + ') ' + `${camposFaltantes[j]} <span style="color: red">(*)</span> </br>`;
        }
        mensajeAlerta += "</div>";

        Swal.fire({
            icon: 'warning',
            title: 'Campos faltantes',
            html: mensajeAlerta,
            allowHtml: true, // Permitir interpretación HTML
            confirmButtonColor: '#3085d6',
        });

        return; // Detener la ejecución del código
    }

 

  var correo = $("#txtCorreoTrabajadorc").val();

    if (!validarCorreo(correo)) {
        Swal.fire({
            icon: 'error',
            title: 'Correo inválido',
            text: 'Por favor ingrese un correo electrónico válido en el formato example@domain.com',
            confirmButtonText: 'Entendido'
        });
        $("#txtCorreoTrabajadorc").focus();
        return;
    }


    var edad = parseInt($("#txtEdadTrabajadorc").val());

    // Validar que la edad esté dentro del rango permitido (18-45 años)
    if (edad < 18 || edad > 45 || isNaN(edad)) {
        Swal.fire({
            icon: 'error',
            title: 'Edad inválida',
            text: 'Por favor ingrese una edad válida entre 18 y 45 años.',
            confirmButtonText: 'Entendido'
        });
        $("#txtEdadTrabajadorc").focus();
        return;
    }


    // Confirmar antes de crear un trabajador
    Swal.fire({
        icon: 'question',
        title: '¿Estás seguro de registrar trabajador?',
        
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí',
        cancelButtonText: "No",
    }).then((result) => {
        if (result.isConfirmed) {
            // Si el usuario confirma, proceder a crear el trabajador
            var nombre = $("#txtNombreTrabajadorc").val();
            var apePaterno = $("#txtApePaternoTrabajadorc").val();
            var apeMaterno = $("#txtApeMaternoTrabajadorc").val();
            var edad = $("#txtEdadTrabajadorc").val();
            var dni = $("#txtDniTrabajadorc").val();
            var celular = $("#txtCelularTrabajadorc").val();
            correo = $("#txtCorreoTrabajadorc").val();
            var direccion = $("#txtDireccionTrabajadorc").val();
            var codEstadoCivil = $("#selEstadoCivilc").val();
            var codDistrito = $("#selDistritoc").val();
            var codArea = $("#selEstadoAreac").val();
            var codCargo = $("#selEstadoCargoc").val();

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
                codDistrito: codDistrito
            };

            $.ajax({
                url: "http://localhost:8081/planilla/crearTrabajador",
                type: "POST",
                data: JSON.stringify(objetoTrabajador),
                contentType: "application/json",
                success: function(respuestaBackend) {
                    console.log(respuestaBackend);
                    $("#modalTrabajador").hide();
                    Swal.fire({
                        icon: 'success',
                        title: '¡Registro exitoso!',
                        text: 'El trabajador se ha creado correctamente.'
                    }).then(() => {
            // Limpiar los campos después de la confirmación de éxito
            $("#txtNombreTrabajadorc").val("");
            $("#txtApePaternoTrabajadorc").val("");
            $("#txtApeMaternoTrabajadorc").val("");
            $("#txtDniTrabajadorc").val("");
            $("#txtEdadTrabajadorc").val("");
            $("#txtCelularTrabajadorc").val("");
            $("#txtCorreoTrabajadorc").val("");
            $("#txtDireccionTrabajadorc").val("");
            $("#selEstadoCivilc").val("");
            $("#selEstadoAreac").val("");
            $("#selEstadoCargoc").val("");
            $("#selDistritoc").val("");
        });
    },
                error: function() {
                    console.error("No es posible completar la operación");
                }
            });
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
				  $("#selEstadoCivilc").append(`<option value="" disabled selected hidden>Seleccionar</option>`);
                

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
				
				 
                  $("#selEstadoCargoc").append(`<option value="" disabled selected hidden>Seleccionar</option>`);
          
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
				
				 $("#selEstadoAreac").append(`<option value="" disabled selected hidden>Seleccionar</option>`);
                

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
				 $("#selDistritoc").append(`<option value="" disabled selected hidden>Seleccionar</option>`);
                

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


/** metodo para  cerrar las  vetantanas  */
function fn_cerrar() {
    var modalTrabajador = $("#modalTrabajador");
    var modalCrearTrabajador = $("#modalCrearTrabajador");

    if (modalTrabajador.length > 0) {
        modalTrabajador.hide();
    }

    if (modalCrearTrabajador.length > 0) {
        modalCrearTrabajador.hide();
    }
}
