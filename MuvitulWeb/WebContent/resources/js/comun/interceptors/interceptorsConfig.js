angular.module("indexModule").config(function ($httpProvider) {
	$httpProvider.interceptors.push("requestInterceptor");
 });