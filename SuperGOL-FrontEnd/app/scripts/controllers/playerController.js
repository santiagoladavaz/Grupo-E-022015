function PlayerController($scope, $location, $http, $translate, $routeParams) {

 $scope.positions = ['Goal Keeper', 'Defender','Mid Field', 'Forward'];

 $scope.players = [];

 $scope.getPlayers = function() {
    $http.get('http://10.9.6.146:8080/SuperGol-BackEnd/rest/playerService/getAll').success(function(data){
        $scope.players = data;
      });
  };



  $scope.savePlayer = function(data, index) {
    var player = $scope.players[index];
    alert(data.position);
    alert(data.team);
    alert(data.name);
    alert(data.idPlayer);
    if(player.id == null)
        $http.post('http://10.9.6.146:8080/SuperGol-BackEnd/rest/playerService/create',player).success(function(response){
  	         $player.id = response.id;
  	    });
  	else
        $http.post('http://10.9.6.146:8080/SuperGol-BackEnd/rest/playerService/edit',player);

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

