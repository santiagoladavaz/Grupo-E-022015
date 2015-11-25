function routes($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'views/main.html',
      controller: 'MainController'
    })
    .when('/register', {
      templateUrl: 'views/register.html',
      controller: 'RegisterController'
    })
    .when('/login', {
      templateUrl: 'views/login.html',
      controller: 'LoginController'
    })
    .when('/team', {
      templateUrl: 'views/team.html',
      controller: 'TeamController'
    })
    .when('/leagues', {
      templateUrl: 'views/leagues.html',
      controller: 'LeagueController'
    })
    .when('/players', {
      templateUrl: 'views/players.html',      
      controller: 'PlayerController'
    })
    .when('/actualizarFecha', {
      templateUrl: 'views/actualizarFecha.html',      
      controller: 'ActualizarController'
    })
    .otherwise({
      redirectTo: '/'
    });
}