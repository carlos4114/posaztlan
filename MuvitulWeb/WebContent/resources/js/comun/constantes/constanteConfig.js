angular.module('indexModule').constant("constante", {

	// baseUrl: "http://localhost:8080/muvitul-service/rest"
	urlWs : "/muvitul-service/rest"

});

angular.module('indexModule').factory(
		'config',
		[ '$http', '$location', 'constante', '$rootScope',
				function($http, $location, constante, $rootScope) {

					var protocol = $location.protocol() + "://";
					var host = location.host;
					var url = protocol + host + constante.urlWs;
					var absUrl = $location.absUrl();
					var arrayLocation = $location.absUrl().split('/');
					var path = '/' + arrayLocation[3];
					$rootScope.applet_route = url;

					return {
						baseUrl : url,
						host : host,
						path : path,
						absUrl : absUrl,
						arrayLocation : arrayLocation
					}
				} ]);

