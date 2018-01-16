angular.module('indexModule').constant("constante", {

	// baseUrl: "http://localhost:8080/MuvitulServices/rest"
	urlWs : "/MuvitulServices/rest",
	urlSeguridadWs : "/SeguridadServices/rest"
});

angular.module('indexModule').factory(
		'config',
		[ '$http', '$location', 'constante', '$rootScope',
				function($http, $location, constante, $rootScope) {

					var protocol = $location.protocol() + "://";
					var host = location.host;
					var url = protocol + host + constante.urlWs;
					var urlSeguridad = protocol + host + constante.urlSeguridadWs;
					var absUrl = $location.absUrl();
					var arrayLocation = $location.absUrl().split('/');
					var path = '/' + arrayLocation[3];

					return {
						baseUrl : url,
						baseSeguridadUrl: urlSeguridad,
						host : host,
						path : path,
						absUrl : absUrl,
						arrayLocation : arrayLocation
					}
				} ]);

