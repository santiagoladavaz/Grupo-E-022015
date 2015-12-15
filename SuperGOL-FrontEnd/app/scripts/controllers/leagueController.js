function LeagueController($scope, $translate, $http, auth, store, $cookies) {

  $scope.leagues = [];
  $scope.user = $cookies.get('user');

 $scope.getLeagues = function() {
    //$http.get('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/all').success(function(data){
    $http.get('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/all').success(function(data){   

        $scope.leagues = data;
      });
  };



  $scope.saveLeague = function() {
     var data = {
          name : $scope.name,
          cantMin : $scope.cantMin,
          cantMax: $scope.cantMax
        }
    //$http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/create',data).success(function(response){
      $http.post('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/create',data).success(function(response){     
            $scope.leagues.push(response);
      });
    
  };

  $scope.editLeague = function(data, index) {
    $http.post('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/edit',data);
    //$http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/edit',data);

  };

  
  $scope.removeLeague = function(idLeague, index) {
    $scope.leagues.splice(index, 1);
    $http.get('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/remove/'+idLeague);
    //$http.get('http://192.168.0.21/SuperGol-BackEnd/rest/leagueService/remove/'+league.id);
  };


  $scope.joinLeague = function(id) {
    var data = {
          idLeague : id, 
          username : $scope.user
    };

    //$http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/join/',data).success(function(){
    $http.post('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/join/',data).success(function(response){  
      swal("Te uniste a la liga","Bien hecho","success");
    }).error(function(data,status,response){
     swal("Error", "No se pudo unir a la liga", "error")
    });
  };


  
  $scope.createFixture = function(id){
    $http.get('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/createFixture/'+id).success(function(){
      swal('Se creo el fixture',"Bien hecho","success");
    }).error(function(data,status,response){
     swal("Error", "No se pudo crear el fixture", "error")
    });
  }

  
  $scope.addLeague = function() {
    $scope.inserted = {
      name: '',
      status: null,
      group: null 
    };
    
    $scope.leagues.push($scope.inserted);

  };
};

