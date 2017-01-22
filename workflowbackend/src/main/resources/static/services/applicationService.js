
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

        this.getApplication = function(applicationId) {
            var defer = $q.defer();
            $http.get('/application/'+applicationId)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }

        this.addApplication = function(data) {
            var defer = $q.defer();
            $http.post('/application/', data)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.deleteApplication = function(id){
            var defer = $q.defer();
            $http.delete('/application/'+id)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.updateApplication = function(data){
            var defer = $q.defer();

            $http.put('/application/'+data.applicationId, data)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.actionApplication = function(applicationId, updateAction){
            var defer = $q.defer();
            data = {"updateAction":updateAction}
            $http.put('/actionapplication/'+applicationId, data)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    });
