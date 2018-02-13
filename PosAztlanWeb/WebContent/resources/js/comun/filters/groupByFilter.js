'use strict';
angular.module("indexModule").filter('groupBy', function($parse) {
	return _.memoize(function(items, filtro) {
		var getter = $parse(filtro);
		return _.groupBy(items, function(item) {
			return getter(item);
		});
	});
});

 
 
 
 