'use strict';

var playerApp = angular.module('PlayerApp', []);


playerApp.controller('PlayerController', function ($scope, $http) {
		
		$scope.createPlayer = function(){
		    var player = {
		    	name : $scope.name,
		    	lastName : $scope.lastName,
		    	team: $scope.team,
		    	position:$scope.position
		    }
			$http.post('/createPlayer',player).success(function(data){

			});
		}
		
});