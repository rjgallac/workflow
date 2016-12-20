'use strict';

/**
 * @ngdoc overview
 * @name codemarksfrontApp
 * @description
 * # codemarksfrontApp
 *
 * Main module of the application.
 */
angular
    .module('vacancyApp', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl'
            })
            .when('/about', {
                templateUrl: 'views/about.html',
                controller: 'AboutCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });