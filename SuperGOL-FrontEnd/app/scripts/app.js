'use strict';

var app = angular.module('frontendApp', [
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'pascalprecht.translate',
    'xeditable',
    'angularUtils.directives.dirPagination',
    'ui.bootstrap'
    
  ]);



app.controller('MainController', ['$scope', '$translate', MainController]);
app.controller('RegisterController', ['$scope','$http', '$location','$translate', RegisterController]);
app.controller('LoginController', ['$scope', '$http', '$location', '$routeParams', '$translate', '$cookies', 'auth', 'store', LoginController]);
app.controller('PlayerController', ['$scope', '$location', '$http','$translate','$routeParams', PlayerController]);
app.controller('TeamController', ['$scope', '$location', '$http', '$translate',  TeamController]);
app.controller('LeagueController', ['$scope', '$translate', '$http', LeagueController]);
app.controller('ActualizarController', ['$scope', '$translate', '$http', ActualizarController]);

app.config(["$routeProvider", "$translateProvider", configuration]);

