function RegisterController($scope, $http, $location, $translate) {
	$scope.alerts = [];
	$scope.timeout = 3000;

	
		$scope.createUser = function(){
		    var user = {
		    	nombre : $scope.user,
		    	email : $scope.email,
		    	pass: $scope.pass
		    }
			$http.post('http://localhost:8080/SuperGol-BackEnd/rest/userService/create',user).success(function(data){
				 $scope.alerts.push({msg: 'Registrado con Exito.', type:'success'});

			});
		}
		
		//$http.post('http://localhost:8080/SuperGol-BackEnd/rest/userService/create',user).success(function(data){
	};