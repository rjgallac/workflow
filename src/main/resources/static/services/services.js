
angular.module('workflowApp')
    .service('workflowService', function($http, $q) {
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
    });
