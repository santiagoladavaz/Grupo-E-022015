function PlayerController($scope, $location, $http, $translate, $routeParams) {

  $scope.players = [];

 $scope.getPlayers = function() {
    $http.get('http://10.9.6.146:8080/SuperGol-BackEnd/rest/playerService/all').success(function(data){
        $scope.players = data;
      });
  };



  $scope.savePlayer = function(data, index) {
 	if(data.id == null)
	    $http.post('http://10.9.6.146:8080/SuperGol-BackEnd/rest/playerService/create',data).success(function(response){
	         $data.id = response.id;
	    });
	else
	    $http.post('http://10.9.6.146:8080/SuperGol-BackEnd/rest/playerService/edit',data);

  };

  
  $scope.removePlayer = function(index) {
    var  player = $scope.players[index];
    $scope.players.splice(index, 1);
    $http.get('http://10.9.6.146:8080/SuperGol-BackEnd/rest/playerService/remove/'+player.id);
  };

  // add user
  $scope.addPlayer = function() {
    $scope.inserted = {
      name: '',
      status: null,
      group: null 
    };
    $scope.players.push($scope.inserted);

  };
};

