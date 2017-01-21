
angular.module('workflowApp')
    .service('reviewerService', function($http, $q) {
        this.getReviewers = function() {
            var defer = $q.defer();
            $http.get('/reviewer/')
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.addReviewer = function(data) {
            var defer = $q.defer();
            $http.post('/reviewer/', data)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }


        this.deleteReviewer = function(id){
            var defer = $q.defer();
            $http.delete('/reviewer/'+id)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }

    });
