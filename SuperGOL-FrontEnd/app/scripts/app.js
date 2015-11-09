'use strict';

var app = angular.module('frontendApp', [
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'pascalprecht.translate',
    'xeditable'
  ]);



app.controller('MainController', ['$scope', '$translate', MainController]);
app.controller('RegisterController', ['$scope', '$location','$translate', RegisterController]);
app.controller('LoginController', ['$scope', '$http', '$location', '$routeParams', '$translate', '$cookies', LoginController]);
app.controller('PlayerController', ['$scope', '$location', '$http','$translate','$routeParams', PlayerController]);
app.controller('TeamController', ['$scope', '$location','$translate','$routeParams',  TeamController]);
app.controller('LeagueController', ['$scope', '$translate', '$http', LeagueController]);

app.config(["$routeProvider", "$translateProvider", configuration]);