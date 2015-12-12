function LoginController($scope, $http, $location, $routeParams, $translate, $cookies, auth, store) {
	
   $scope.login = function(){	

    auth.signin({}, function (profile, token) {
      alert(profile);
      // Success callback
      store.set('profile', profile);
      store.set('token', token);
      $location.path('/');
    }, function () {

    });
   
 };
		
}		//$http.post('http://localhost:8080/SuperGol-BackEnd/rest/userService/create',user).success(function(data){
	