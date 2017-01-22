
angular.module('workflowApp')
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
        this.getJob = function(jobId) {
            var defer = $q.defer();
            $http.get('/job/'+jobId)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.deleteJob = function(id) {
            var defer = $q.defer();
            $http.delete('/job/'+id)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.addJob = function(data) {
            var defer = $q.defer();
            $http.post('/job/', data)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.updateJob = function(data){
            var defer = $q.defer();

            $http.put('/job/'+data.jobId, data)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
        this.updateActionJob = function(id, updateAction){
            var defer = $q.defer();
            data = {"updateAction":updateAction}
        console.log(id);

            $http.put('/actionjob/'+id, data)
                .success(function(data) {
                    defer.resolve(data);
                })
                .error(function(err, status) {
                    defer.reject(err);
                });
            return defer.promise;
        }
    });
