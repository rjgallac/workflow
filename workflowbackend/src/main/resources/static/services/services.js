
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