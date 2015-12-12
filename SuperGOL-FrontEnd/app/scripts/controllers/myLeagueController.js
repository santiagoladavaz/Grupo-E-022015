function MyLeaguesController($scope, $translate, $http, auth, store, $cookies) {

  $scope.leagues = [];
  $scope.user = $cookies.get('user');

 $scope.getLeagues = function() {
    $http.get('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/myLeagues/'+$scope.user).success(function(data){
    //$http.get('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/all').success(function(data){   

        $scope.leagues = data;
      });
  };



  $scope.saveLeague = function() {
     var data = {
          name : $scope.name,
          cantMin : $scope.cantMin,
          cantMax: $scope.cantMax
        }
    $http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/create',data).success(function(response){
      //$http.post('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/create',data).success(function(response){     
            $scope.leagues.push(response);
      });
    
  };

  $scope.editLeague = function(data, index) {
    //$http.post('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/edit',data);
    $http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/edit',data);

  };

  
  $scope.removeLeague = function(idLeague, index) {
    $scope.leagues.splice(index, 1);
    //$http.get('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/remove/'+idLeague);
    $http.get('http://192.168.0.21/SuperGol-BackEnd/rest/leagueService/remove/'+league.id);
  };


  $scope.createFixture = function(id){
    $http.get('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/createFixture/'+id).success(function(){
      swal('Se creo el fixture',"Bien hecho","success");
    });
  }

  
  $scope.getInfo = function(id){
     $http.get('http://192.168.0.21:8080/SuperGol-BackEnd/rest/leagueService/detailLeague/'+id).success(function(response){
        $scope.ranking = response.rankingResponse;
        $scope.fixture = response.dateResponse;
    });



  };

  


};

