function MainController($scope, $translate, $cookies, auth, store, $log, $location, $http) {

  $scope.user = $cookies.get('user');
  $scope.alerts = [];
  $scope.timeout = 3000;


  $scope.changeLanguage = function (langKey) {
    $translate.use(langKey);
  };

  $scope.login = function(){	
   	auth.signin({}, function (profile, token) {
      // Success callback
      store.set('profile', profile);
      store.set('token', token);
      $cookies.put('user', auth.profile.nickname);
      $("#divLogin").css('display', 'block');
      $("#btnLogin").css('display', 'none');
      $scope.user = $cookies.get('user');
      alert($scope.user);
      $http.post('http://192.168.0.21:8080/SuperGol-BackEnd/rest/userService/create',$scope.user);
      //window.location.reload(false); 
//      $location.path('/');
      //$scope.alerts.push({msg: 'Registrado con Exito.', type:'success'});
    }, function () {
    	 
   	   });
  };

  $scope.logout = function() {
   auth.signout();
   store.remove('profile');
   store.remove('token');
   $cookies.remove('user');
   $("#divLogin").css('display', 'none');
   $("#btnLogin").css('display', 'block');
   $location.path('/');
   //$scope.alerts.push({msg: 'Se cerro la sesion', type:'success'});
}

}
