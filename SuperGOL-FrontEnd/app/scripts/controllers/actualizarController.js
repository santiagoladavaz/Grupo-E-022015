
function ActualizarController($scope, $translate, $http, Upload) {
	
	$scope.upload = function(file) {
     var data =  {
          name : file.name,
          file : file
    };
    
    $http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/upload',file).success(function(response){
      //$http.post('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/create',data).success(function(response){     
           alert('Se actualizo la fecha');
      });

    /*
  file.upload = Upload.upload({
      url: 'https://angular-file-upload-cors-srv.appspot.com/upload',
      data: {file: file, username: $scope.username},
    });
    /*
    file.upload.then(function (response) {
      $timeout(function () {
        file.result = response.data;
      });
    }, function (response) {
      if (response.status > 0)
        $scope.errorMsg = response.status + ': ' + response.data;
    }, function (evt) {
      // Math.min is to fix IE which reports 200% sometimes
      file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
    });
    }
*/
  
};
  
};
