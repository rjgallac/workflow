
angular.module('workflowApp')
    .service('reviewService', function($http, $q) {
        this.getReviews = function() {
            var defer = $q.defer();
            $http.get('/review/')
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.addReview = function(data) {
            var defer = $q.defer();
            $http.post('/review/', data)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.deleteReview = function(id){
            var defer = $q.defer();
            $http.delete('/review/'+id)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    });
