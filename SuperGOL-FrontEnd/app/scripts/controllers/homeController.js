var app = angular.module('HomeApp', ['pascalprecht.translate']);

app.config(function($translateProvider) {
  $translateProvider.translations('en', {
    HEADLINE: 'Hello there, This is my awesome app!',
    INTRO_TEXT: 'And it has i18n support!',
    BUTTON_TEXT_EN: 'english',
    BUTTON_TEXT_ES: 'spanish'
  })
  .translations('es', {
    HEADLINE: 'Hola Soy una aplicacion',
    INTRO_TEXT: 'Sigo en español',
    BUTTON_TEXT_EN: 'ingles',
    BUTTON_TEXT_DE: 'español'
  });
  $translateProvider.preferredLanguage('en');
});


app.controller('HomeController', function($translate, $scope) {
  $scope.changeLanguage = function (langKey) {
    $translate.use(langKey);
  };
});
