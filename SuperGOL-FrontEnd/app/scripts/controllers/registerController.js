'use strict';

var registerApp = angular.module('RegisterApp', []);


/* Controllers */
registerApp.controller('RegisterController', function ($scope, $http) {
		
		$scope.createUser = function(){
		    var user = {
		    	nombre : $scope.user,
		    	email : $scope.email,
		    	pass: $scope.pass
		    }
			$http.post('http://192.168.1.105:8080/SuperGol-BackEnd/rest/userService/create',user).success(function(data){
				alert("Se creo un usuario");

			});
		}
		
		//$http.post('http://localhost:8080/SuperGol-BackEnd/rest/userService/create',user).success(function(data){
	});