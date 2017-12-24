'use strict';

angular.module('globalModule').factory('ErrorFactory',[function(){
	var listaErrores = {};
	var listaErroresSeguridad = {};

	listaErrores[-1]     = {codigo: -1, mensaje: 'Error en la petici\u00F3n.'};
	listaErrores[400]     = {codigo: 400, mensaje: 'Petici\u00F3n incorrecta.'};
	listaErrores[401]     = {codigo: 401, mensaje: 'No est\u00E1 autorizada la operaci\u00F3n.'};
	listaErrores[402]     = {codigo: 402, mensaje: 'Pago requerido.'};
	listaErrores[403]     = {codigo: 403, mensaje: 'Operaci\u00F3n prohibida.'};
	listaErrores[404]     = {codigo: 404, mensaje: 'Servidor no encontrado.'};
	listaErrores[405]     = {codigo: 405, mensaje: 'M\u00E9todo no permitido.'};
	listaErrores[406]     = {codigo: 406, mensaje: 'Proceso no aceptable.'};
	listaErrores[407]     = {codigo: 407, mensaje: 'Autenticaci\u00F3n requerida.'};
	listaErrores[408]     = {codigo: 408, mensaje: 'Tiempo de espera agotado para la petici\u00F3n.'};
	listaErrores[409]     = {codigo: 409, mensaje: 'Hubo un conflicto con la operaci\u00F3n.'};
	listaErrores[410]     = {codigo: 410, mensaje: 'Operaci\u00F3n no procesada.'};
	listaErrores[411]     = {codigo: 411, mensaje: 'La longitud esperada es incorrecta.'};
	listaErrores[412]     = {codigo: 412, mensaje: 'Fallaron las precondiciones para la operaci\u00F3n.'};
	listaErrores[413]     = {codigo: 413, mensaje: 'El tama\u00F1o de la petici\u00F3n es demasiado grande.'};
	listaErrores[414]     = {codigo: 414, mensaje: 'El tama\u00F1o de la URL es demasiado grande.'};
	listaErrores[415]     = {codigo: 415, mensaje: 'El tipo de medio no esta soportado.'};
	listaErrores[416]     = {codigo: 416, mensaje: 'Rango de la petici\u00F3n no es satisfactorio.'};
	listaErrores[417]     = {codigo: 417, mensaje: 'Expectativa fallida.'};
	listaErrores[418]     = {codigo: 418, mensaje: 'Tetera presente.'};
	listaErrores[419]     = {codigo: 419, mensaje: 'Espacio insuficiente en el recurso.'};
	listaErrores[420]     = {codigo: 420, mensaje: 'Falla en el m\u00E9todo.'};
	listaErrores[421]     = {codigo: 421, mensaje: 'Destinatario bloqueado.'};
	listaErrores[422]     = {codigo: 422, mensaje: 'No se pueden leer los datos.'};
	listaErrores[423]     = {codigo: 423, mensaje: 'Sesi\u00F3n bloqueada.'};
	listaErrores[424]     = {codigo: 424, mensaje: 'Fall\u00F3 la dependencia.'};
	listaErrores[426]     = {codigo: 426, mensaje: 'Se requiere una actualizaci\u00F3n.'};
	listaErrores[428]     = {codigo: 428, mensaje: 'Se requieren otras precondiciones.'};
	listaErrores[429]     = {codigo: 429, mensaje: 'El servidor est\u00E1 resolviendo muchas peticiones.'};
	listaErrores[431]     = {codigo: 431, mensaje: 'Los encabezados de la petici\u00F3n son demasiado grandes.'};

	listaErrores[500]     = {codigo: 500, mensaje: 'Error interno al resolver la operaci\u00F3n.'};
	listaErrores[501]     = {codigo: 501, mensaje: 'Proceso no implementado.'};
	listaErrores[502]     = {codigo: 502, mensaje: 'Puerta de acceso incorrecta.'};
	listaErrores[503]     = {codigo: 503, mensaje: 'El servicio no est\u00E1 disponible.'};
	listaErrores[504]     = {codigo: 504, mensaje: 'Se agot\u00F3 el tiempo de espera para entrar al servidor.'};
	listaErrores[505]     = {codigo: 505, mensaje: 'Versi\u00F3n HTTP no soportada.'};
	listaErrores[506]     = {codigo: 506, mensaje: 'La combinaci\u00F3n no pudo resolverse.'};
	listaErrores[507]     = {codigo: 507, mensaje: 'El almacenamiento es insuficiente.'};
	listaErrores[508]     = {codigo: 508, mensaje: 'Se detect\u00F3 un ciclo en la operaci\u00F3n y no pudo finalizar.'};
	listaErrores[509]     = {codigo: 509, mensaje: 'Se ha exedido el ancho de banda.'};
	listaErrores[510]     = {codigo: 510, mensaje: 'No se pudo extender el tiempo para procesar la operaci\u00F3n.'};
	listaErrores[511]     = {codigo: 511, mensaje: 'Se requiere la autenticaci\u00F3n de red.'};

	//ERRORES DE SEGURIDAD
	listaErroresSeguridad[1]     = {codigo: 1, mensaje: 'El usuario no existe. Verifica tu informaci\u00F3n.'};
	listaErroresSeguridad[2]     = {codigo: 2, mensaje: 'Contrase\u00F1a incorrecta. Verifica tu informaci\u00F3n.'};
	listaErroresSeguridad[3]     = {codigo: 3, mensaje: 'El usuario no se encuentra activo. Consulta al administrador.'};
	listaErroresSeguridad[4]     = {codigo: 4, mensaje: 'La contrase\u00F1a actual no es correcta. Verifica tu informaci\u00F3n.'};
	listaErroresSeguridad[5]     = {codigo: 5, mensaje: 'La empresa presenta un adeudo. Contacta a tu administrador.'};
	listaErroresSeguridad[6]     = {codigo: 6, mensaje: 'La empresa se encuentra inactiva. Contacta a tu administrador.'};
	
    var interfaz = {       
        getErrorMessage: function(errCode){
        	if(listaErrores[errCode])
        		return listaErrores[errCode].mensaje;
        	else
        		return '';
        },
    	getErrorSecurityMessage: function(errCode){
        
    		return listaErroresSeguridad[errCode].mensaje;
    	}
    }
    return interfaz;
}]);