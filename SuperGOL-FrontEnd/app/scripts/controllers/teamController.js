'use strict';

/* Controllers */
var app = angular.module('TeamApp',['ngCookies']);

app.controller('TeamController', ['$scope','$http','$cookies',
                                                                            
	function ($scope, $http, $cookies) {

		
		
		
		$scope.arqueros = [
			{nombre:'Orion',apellido:'Agustin',puesto:'Arquero'},
			{nombre:'Andujar',apellido:'Pedro',puesto:'Arquero'},
			{nombre:'Sessa',apellido:'Esteban',puesto:'Arquero'},
			{nombre:'Garcia',apellido:'Lolo',puesto:'Arquero'},
			{nombre:'Perez',apellido:'Agustin',puesto:'Arquero'}
		 ]
		 
		 $scope.defensores = [
			{nombre:'Saw',apellido:'Agustin',puesto:'Defensor'},
			{nombre:'Fede',apellido:'Pedro',puesto:'Defensor'},
			{nombre:'Ern',apellido:'Esteban',puesto:'Defensor'},
		]


		 $scope.volantes = [
			{nombre:'Vera',apellido:'Agustin',puesto:'Volante'},
			{nombre:'Terry',apellido:'Pedro',puesto:'Volante'},
			{nombre:'Rewq',apellido:'Esteban',puesto:'Volante'},
			{nombre:'Vert',apellido:'Lolo',puesto:'Volante'}
		 ]


		  $scope.delanteros = [
			{nombre:'Andrt',apellido:'Palermo',puesto:'Delantero'},
			{nombre:'Certy',apellido:'Pedro',puesto:'Delantero'},
			{nombre:'Xertu',apellido:'Esteban',puesto:'Delantero'}
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
			$http.post('http://10.9.6.114:8080/SuperGol-BackEnd/rest/teamService/create',team).success(function(data){
				alert("Se creo un equipo");
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