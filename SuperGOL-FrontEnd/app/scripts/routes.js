function routes($routeProvider,authProvider) {
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
      controller: 'TeamController',
      requiresLogin: true
    })
    .when('/leagues', {
      templateUrl: 'views/leagues.html',
      controller: 'LeagueController',
      requiresLogin: true
    })
    .when('/players', {
      templateUrl: 'views/players.html',      
      controller: 'PlayerController',
      requiresLogin: true
    })
    .when('/actualizarFecha', {
      templateUrl: 'views/actualizarFecha.html',      
      controller: 'ActualizarController',
      requiresLogin: true
    })
    .otherwise({
      redirectTo: '/'
    });
}