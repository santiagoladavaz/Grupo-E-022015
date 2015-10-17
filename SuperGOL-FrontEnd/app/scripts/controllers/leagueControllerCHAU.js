'use strict';

var leagueApp = angular.module('LeagueApp', []);


leagueApp.controller('LeagueController', function ($scope, $http) {
		
		$scope.createLeague = function(){
		    var league = {
		    	name : $scope.leagueName,
		    	cantiMin : $scope.cantiMin,
		    	cantMax: $scope.cantMax
		    }
			$http.post('/createLeague',league).success(function(data){

			});
		}
		
});