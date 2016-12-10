
angular.module('workflowApp')
    .service('applicationService', function($http, $q) {
        this.getApplications = function() {
            var defer = $q.defer();
            $http.get('/application/')
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    })
    .service('jobService', function($http, $q) {
        this.getJobs = function() {
            var defer = $q.defer();
            $http.get('/job/')
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    })
    .service('applicantService', function($http, $q) {
        this.getApplicants = function() {
            var defer = $q.defer();
            $http.get('/applicant/')
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    });
