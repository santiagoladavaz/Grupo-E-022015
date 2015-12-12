function PlayerController($scope, $location, $http, $translate, $routeParams, auth, store) {

 $scope.positions = ['Goal Keeper', 'Defender','Mid Field', 'Forward'];

 $scope.players = [];
 
 $scope.getPlayers = function() {

    $http.get('http://192.168.0.21:8080/SuperGol-BackEnd/rest/playerService/getAll').success(function(data){
      //$http.get('http://localhost:8080/SuperGol-BackEnd/rest/playerService/getAll').success(function(data){
           $scope.players = data;
      });
  };



  $scope.savePlayer = function() {
        var data = {
          name : $scope.name,
          team : $scope.team,
          position: $scope.position
        }
        //$http.post('http://localhost:8080/SuperGol-BackEnd/rest/playerService/create',data).success(function(response){
        $http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/playerService/create',data).success(function(response){
  	        $scope.players.push(response);
  	    });
  	
  };


  $scope.editPlayer = function(data) {
    //$http.post('http://localhost:8080/SuperGol-BackEnd/rest/playerService/edit',data);
    $http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/playerService/edit',data);

  };

  
  $scope.addPlayer = function() {

    $scope.inserted = {
      name: '',
      status: null,
      group: null 
    };
    $scope.players.push($scope.inserted);

  };

};

