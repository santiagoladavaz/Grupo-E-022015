'use strict';

/* Controllers */
angular.module('RegisterApp').controller('RegisterController', ['$scope','$http',
                                                                            
	function ($scope, $http) {
		
		$scope.createUser = function(){
		    var user = {
		    	nombre : $scope.user,
		    	email : $scope.email,
		    	pass: $scope.pass
		    }
			$http.post('/createUser',user).success(function(data){

			});
		}
		
	}
]);