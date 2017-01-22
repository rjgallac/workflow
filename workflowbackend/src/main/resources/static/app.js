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
    .module('workflowApp', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/home.html',
                controller: 'homeController'
            })
            .when('/applications', {
                templateUrl: 'views/applications.html',
                controller: 'applicationCtrl'
            })
            .when('/jobs', {
                templateUrl: 'views/jobs.html',
                controller: 'jobCtrl'
            })
            .when('/applicants', {
                templateUrl: 'views/applicants.html',
                controller: 'applicantCtrl'
            })
            .when('/reviewers', {
                templateUrl: 'views/reviewers.html',
                controller: 'reviewerCtrl'
            })
            .when('/reviews', {
                templateUrl: 'views/reviews.html',
                controller: 'reviewCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });