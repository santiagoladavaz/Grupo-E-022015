//var app = angular.module("LeagueApp", ["xeditable"]);
//app.controller('LeagueController', function($scope, $filter, $http) {

function LeagueController($scope, $translate, $http) {

  $scope.leagues = [];

 $scope.getLeagues = function() {
    $http.get('http://10.9.6.146:8080/SuperGol-BackEnd/rest/leagueService/all').success(function(data){
        $scope.leagues = data;
      });
  };



  $scope.saveLeague = function(data, index) {


 
  if(data.id == null)
      $http.post('http://10.9.6.146:8080/SuperGol-BackEnd/rest/leagueService/create',data).success(function(response){
         $data.id = response.id;
      });
  else
      $http.post('http://10.9.6.146:8080/SuperGol-BackEnd/rest/leagueService/edit',data);

  };

  
  $scope.removeLeague = function(index) {
    var  league = $scope.leagues[index];
    $scope.leagues.splice(index, 1);
    $http.get('http://10.9.6.146:8080/SuperGol-BackEnd/rest/leagueService/remove/'+league.id);
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

