var myApp = angular.module('AppModule',['ngRoute']);

/*********************** CONFIGURER LES ROUTES ***********************/
myApp.config(['$routeProvider','$locationProvider',function($routeProvider,$locationProvider) {
	$routeProvider.when('/home',{
		templateUrl: 'pages/home.html'
	}).when('/contact',{
		templateUrl: 'pages/contact.html'
	}).when('/',{
		templateUrl: 'pages/home.html'
	});
	$locationProvider.hashPrefix('');
	$locationProvider.html5Mode({
		enabled: true,
		requireBase: false
	});
}]);
myApp.controller('cont',['$scope', function($scope){
	$scope.logout = function () {
		window.location.href = "/logout";
	}
}]);