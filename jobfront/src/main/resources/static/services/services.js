
angular.module('vacancyApp')
    .service('vacancyService', function($http, $q) {
        this.getVacancies = function() {
            var defer = $q.defer();
            $http.get('/vacancy/')
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    });
