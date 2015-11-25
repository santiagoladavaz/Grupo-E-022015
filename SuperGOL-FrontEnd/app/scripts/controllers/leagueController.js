//var app = angular.module("LeagueApp", ["xeditable"]);
//app.controller('LeagueController', function($scope, $filter, $http) {

function LeagueController($scope, $translate, $http) {

  $scope.leagues = [];

 $scope.getLeagues = function() {
    $http.get('http://10.9.6.146:8080/SuperGol-BackEnd/rest/leagueService/all').success(function(data){
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
    $http.post('http://10.9.6.146:8080/SuperGol-BackEnd/rest/leagueService/create',data).success(function(response){
      //$http.post('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/create',data).success(function(response){     
            $scope.leagues.push(response);
      });
    
  };

  $scope.editLeague = function(data, index) {
    //$http.post('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/edit',data);
    $http.post('http://10.9.6.146:8080/SuperGol-BackEnd/rest/leagueService/edit',data);

  };

  
  $scope.removeLeague = function(idLeague, index) {
    $scope.leagues.splice(index, 1);
    //$http.get('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/remove/'+idLeague);
    $http.get('http://10.9.6.146:8080/SuperGol-BackEnd/rest/leagueService/remove/'+league.id);
  };


  $scope.joinLeague = function(id) {
    //$http.get('http://localhost:8080/SuperGol-BackEnd/rest/leagueService/join/'+idLeague);
    alert(id);
    var data = {
          idLeague : id, 
          username : "Pepito"
    };

    $http.post('http://10.9.6.146:8080/SuperGol-BackEnd/rest/leagueService/join/',data).success(function(){
      alert('te uniste!');
    });
    
  };

  
  $scope.addLeague = function() {
    $scope.inserted = {
      name: '',
      status: null,
      group: null 
    };
    
    $scope.leagues.push($scope.inserted);

  };
};

