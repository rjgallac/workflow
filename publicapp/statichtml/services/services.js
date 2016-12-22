
angular.module('vacancyApp')
    .service('vacancyService', function($http, $q) {
        this.getVacancies = function() {
            var defer = $q.defer();
            $http.get('http://127.0.0.1:8081/vacancy/')
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
            $http.get('http://127.0.0.1:8081/company/')
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
            $http.get('http://127.0.0.1:8081/advert/')
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    })
    .service('applicationService', function($http, $q) {
        this.postApplication = function() {
            var defer = $q.defer();
            console.log("posting");
            $http.post('http://127.0.0.1:8083/myapp/myservice/',{"asfd":"asdf"})
              .success(function(data) {
                  defer.resolve(data);
              })
              .error(function(err, status) {
                  defer.reject(err);
              });
            return defer.promise;
            }
        });
