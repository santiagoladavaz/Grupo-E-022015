
//var loginApp = angular.module('LoginApp', ['ngCookies']);
//loginApp.controller('LoginController', function ($scope, $http, $cookies, $location) {


function LoginController($scope, $http, $location, $routeParams, $translate, $cookies) {
	
    $scope.login = function()
    {	
    	//guardo el usuario
    	$cookies.put('user', $scope.username);

    	//$scope.user = $cookies.get('user'); de esta manera lo obtengo
       $location.path('/team')
    }
   
 };
		
		//$http.post('http://localhost:8080/SuperGol-BackEnd/rest/userService/create',user).success(function(data){
	