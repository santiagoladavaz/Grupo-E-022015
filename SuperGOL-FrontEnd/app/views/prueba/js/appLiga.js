var app = angular.module("app", ["xeditable", "ngMockE2E"]);

app.run(function(editableOptions) {
  editableOptions.theme = 'bs3';
});

app.controller('Ctrl', function($scope, $filter, $http) {

  $scope.leagues = [
			{id:1,name:'Liga1',cantMin:1,cantMax:5},
			{id:2,name:'Liga2',cantMin:5,cantMax:10},
			{id:3,name:'Liga3',cantMin:12,cantMax:41},
			{id:4,name:'Liga4',cantMin:1,cantMax:2},
			{id:5,name:'Liga5',cantMin:1,cantMax:5}
		 ]



  //$scope.checkName = function(data, id) {
  //  if (id === 2 && data !== 'awesome') {
   //   return "Username 2 should be `awesome`";
   // }
  //};

  $scope.saveUser = function(data, id) {
    //$scope.user not updated yet
    angular.extend(data, {id: id});
    return $http.post('/saveUser', data);
  };

  // remove user
  $scope.removeUser = function(index, data) {
    $scope.leagues.splice(index, 1);
	//alert($scope.leagues[index].name);
  };

  // add user
  $scope.addUser = function() {
    $scope.inserted = {
      id: $scope.leagues.length+1,
      name: '',
      status: null,
      group: null 
    };
    $scope.leagues.push($scope.inserted);
  };
});



// --------------- mock $http requests ----------------------
app.run(function($httpBackend) {
  $httpBackend.whenGET('/groups').respond([
    {id: 1, text: 'user'},
    {id: 2, text: 'customer'},
    {id: 3, text: 'vip'},
    {id: 4, text: 'admin'}
  ]);
    
  $httpBackend.whenPOST(/\/saveUser/).respond(function(method, url, data) {
    data = angular.fromJson(data);
    return [200, {status: 'ok'}];
  });
});

