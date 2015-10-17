'use strict';

/* Controllers */
var app = angular.module('TeamApp',[]);

app.controller('TeamController', ['$scope','$http',
                                                                            
	function ($scope, $http) {
		
		
		$scope.arqueros = [
			{nombre:'Orion'},
			{nombre:'Andujar'},
			{nombre:'Sessa'},
			{nombre:'Garcia'},
			{nombre:'Perez'}
		 ]
		 
		 $scope.defensores = [
			{nombre:'Diaz'},
			{nombre:'Gnomo'},
			{nombre:'Hermione'},
			{nombre:'jajajajaj'}
		 ]
		 
		 $scope.createTeam = function(){
		    var team = {
		    	usuario:'Santi',
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
			$http.post('http://192.168.1.105:8080/SuperGol-BackEnd/rest/teamService/create',team).success(function(data){
				alert("Se creo un usuario");
				$location.path('views/login.html')

			});
			//alert ($scope.arqueroSeleccionado[0].id);
			
			//$('#selectJugador :selected').each(function(i, selected){ 
			  //alert($(selected).text()); 
			//});
		}
		
		$scope.change = function(posicion, cant){
			
			
			for(var j=1; j <= cant; j++)
			{
				$('#' + posicion + j).html("<h4><span class='label label-danger'>"+ posicion.toUpperCase()+"</span></h4>");
			}
			
			switch(posicion){
				case "arquero":
					$('#arquero1').html("<h4><span class='label label-success'>" + $scope.arqueroSeleccionado[0].nombre+ "</span></h4>");
					break;
				case "defensor":
					for(var i=1; i <= $scope.defensoresSeleccionados.length; i++)
					{
						$('#defensor' + i).html("<h4><span class='label label-success'>" + $scope.defensoresSeleccionados[i-1].nombre + "</span></h4>");
					}
					break;
				
				case "volante":
					for(var i=1; i <= $scope.volantesSeleccionados.length; i++)
					{
						$('#volante' + i).html("<h4><span class='label label-success'>" +$scope.volantesSeleccionados[i-1].nombre+ "</span></h4>");
					}
					break;
				case "delantero":
					for(var i=1; i <= $scope.delanterosSeleccionados.length; i++)
					{
						$('#delantero' + i).html("<h4><span class='label label-success'>" +$scope.delanterosSeleccionados[i-1].nombre+ "</span></h4>");
					}
					break;
			}
		}
		
		
		
		
	}
		
	
		

]);