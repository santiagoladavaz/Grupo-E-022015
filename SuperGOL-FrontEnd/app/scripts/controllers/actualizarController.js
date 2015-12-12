
function ActualizarController($scope, $translate, $http, Upload) {
	
	$scope.upload = function(file) {
     var data =  {
          name : file.name,
          file : file
    };
    
    $http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/upload',file).success(function(response){
      //$http.post('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/create',data).success(function(response){     
          swal("Se actualizo la fecha","Bien hecho","success");
      });
 
  };
  
};
