
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
    })
    .service('companyService', function($http, $q) {
        this.getCompanies = function() {
            var defer = $q.defer();
            $http.get('/company/')
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    })
    .service('advertService', function($http, $q) {
        this.getAdverts = function() {
            var defer = $q.defer();
            $http.get('/advert/')
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    });
