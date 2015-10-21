'use strict';

var loginApp = angular.module('LoginApp', ['ngCookies']);


/* Controllers */
loginApp.controller('LoginController', function ($scope, $http, $cookies, $location) {
	
	
    $scope.login = function()
    {	
    	//guardo el usuario
    	$cookies.put('user', $scope.username);

    	//$scope.user = $cookies.get('user'); de esta manera lo obtengo
       	window.location.href="http://localhost:9000/views/armarEquipo.html";
    }
   
 });
		
		//$http.post('http://localhost:8080/SuperGol-BackEnd/rest/userService/create',user).success(function(data){
	