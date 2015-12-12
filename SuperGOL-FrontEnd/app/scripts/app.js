'use strict';

var app = angular.module('frontendApp', [
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'pascalprecht.translate',
    'xeditable',
    'angularUtils.directives.dirPagination',
    'ui.bootstrap',
    'auth0',
    'angular-storage',
    'angular-jwt',
    'angularFileUpload',
    'ngFileUpload'
]);



app.controller('MainController', ['$scope', '$translate','$cookies', 'auth', 'store','$log','$location','$http', MainController]);
app.controller('RegisterController', ['$scope','$http', '$location','$translate', RegisterController]);
app.controller('LoginController', ['$scope', '$http', '$location', '$routeParams', '$translate', '$cookies', 'auth', 'store', LoginController]);
app.controller('PlayerController', ['$scope', '$location', '$http','$translate','$routeParams','auth', 'store', PlayerController]);
app.controller('TeamController', ['$scope', '$location', '$http', '$translate','auth', 'store','$cookies', TeamController]);
app.controller('LeagueController', ['$scope', '$translate', '$http','auth', 'store','$cookies', LeagueController]);
app.controller('ActualizarController', ['$scope', '$translate', '$http','Upload', ActualizarController]);


app.config(["$routeProvider", "$translateProvider",'$locationProvider', configuration]);


app.config(function (authProvider) {
  authProvider.init({
    domain: 'supergol.auth0.com',
    clientID: '0244WN47n4btz994kvC6FK217uFMqOpE',
    callbackURL: location.href,
    // Here include the URL to redirect to if the user tries to access a resource when not authenticated.
    loginUrl: '/'
  });
})
.run(function(auth) {
  // This hooks al auth events to check everything as soon as the app starts
  auth.hookEvents();
});


app.run(function($rootScope, auth, store, jwtHelper, $location) {
  // This events gets triggered on refresh or URL change
  $rootScope.$on('$locationChangeStart', function() {
    var token = store.get('token');
    if (token) 
    {
      if (!jwtHelper.isTokenExpired(token)) 
      {
        if (!auth.isAuthenticated) 
        {
          auth.authenticate(store.get('profile'), token);
        }

        setTimeout(function(){ $("#btnLogin").css('display', 'none'); }, 100);
      } 
      else 
      {
        // Either show the login page or use the refresh token to get a new idToken
        $location.path('/');
        $("#divLogin").css('display', 'none');
        $("#btnLogin").css('display', 'block');
      }
    }
    else
    {
      $("#divLogin").css('display', 'none');
      $("#btnLogin").css('display', 'block');
    }
  });
});
  