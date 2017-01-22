
angular.module('workflowApp')
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

        this.getApplicant = function(applicantId) {
            var defer = $q.defer();
            $http.get('/applicant/'+applicantId)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }

        this.deleteApplicant = function(id) {
            var defer = $q.defer();
            $http.delete('/applicant/'+id)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.addApplicant = function(applicant){
            var defer = $q.defer();
            $http.post('/applicant/', applicant)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    });
