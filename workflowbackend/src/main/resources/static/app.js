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
            .when('/applicationdetail/:param', {
                templateUrl: 'views/applicationdetail.html',
                controller: 'applicationDetailCtrl'
            })
            .when('/jobs', {
                templateUrl: 'views/jobs.html',
                controller: 'jobCtrl'
            })
            .when('/jobdetail/:param', {
                templateUrl: 'views/jobdetail.html',
                controller: 'jobDetailCtrl'
            })
            .when('/applicants', {
                templateUrl: 'views/applicants.html',
                controller: 'applicantCtrl'
            })
            .when('/applicantdetail/:param', {
                templateUrl: 'views/applicantdetail.html',
                controller: 'applicantDetailCtrl'
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