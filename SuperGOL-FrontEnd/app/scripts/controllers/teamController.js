function TeamController($scope, $location, $http, $translate, auth, store, $cookies) {

	 $scope.user = $cookies.get('user');
	 $scope.hayJugadores = false;
		
	$scope.getPlayers = function() {
    	$http.get('http://localhost:8080/SuperGol-BackEnd/rest/playerService/getAll').success(function(data){
    	//$http.get('http://192.168.0.21:8080/SuperGol-BackEnd/rest/playerService/getAll').success(function(data){
       		$scope.players = data;
       	});
  	};

		
		 
	$scope.createTeam = function(){
		try{
		    var team = {
		    	usuario:$scope.user,
		    	nombreEquipo: $scope.nombreEquipo,
				arquero: $scope.arqueroSeleccionado[0],
		    	defensor1 : $scope.defensoresSeleccionados[0],
				defensor2 : $scope.defensoresSeleccionados[1],
				defensor3 : $scope.defensoresSeleccionados[2],
				volante1 : $scope.volantesSeleccionados[0],
				volante2 : $scope.volantesSeleccionados[1],
				volante3 : $scope.volantesSeleccionados[2],
				volante4 : $scope.volantesSeleccionados[3],
				delantero1: $scope.delanterosSeleccionados[0],
				delantero2: $scope.delanterosSeleccionados[1],
				delantero3: $scope.delanterosSeleccionados[2],
			}
		}catch(e){
			swal("Error", "Complete su equipo", "error")
		}
			$http.post('http://localhost:8080/SuperGol-BackEnd/rest/teamService/create',team).success(function(data){
			//$http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/teamService/create',team).success(function(data){
				swal("El equipo se creo con exito","Bien hecho","success");
				$location.path('views/login.html')

			}).error(function(data,status,response){
     				swal("Error", "Complete su equipo", "error")
    		});;
			
		}
		
		$scope.change = function(posicion, cant){
			
			
			for(var j=1; j <= cant; j++)
			{
				$('#' + posicion + j).html("<h4><span class='label label-danger'>"+ posicion.toUpperCase()+"</span></h4>");
			}
			
			switch(posicion){
				case "arquero":
					$('#arquero1').html("<h4><span class='label label-success'>" + $scope.arqueroSeleccionado[0].name+ "</span></h4>");
					break;
				case "defensor":
					for(var i=1; i <= $scope.defensoresSeleccionados.length; i++)
					{
						$('#defensor' + i).html("<h4><span class='label label-success'>" + $scope.defensoresSeleccionados[i-1].name + "</span></h4>");
					}
					break;
				
				case "volante":
					for(var i=1; i <= $scope.volantesSeleccionados.length; i++)
					{
						$('#volante' + i).html("<h4><span class='label label-success'>" +$scope.volantesSeleccionados[i-1].name+ "</span></h4>");
					}
					break;
				case "delantero":
					for(var i=1; i <= $scope.delanterosSeleccionados.length; i++)
					{
						$('#delantero' + i).html("<h4><span class='label label-success'>" +$scope.delanterosSeleccionados[i-1].name+ "</span></h4>");
					}
					break;
			}
		}
		
		
	};