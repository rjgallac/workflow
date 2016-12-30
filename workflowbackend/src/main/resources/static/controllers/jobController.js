angular.module('workflowApp')
    .controller('jobCtrl', function ($scope, applicationService, jobService, applicantService) {
        jobs = [];
        jobDto = {};

        jobService.getJobs().then(function(data){
            $scope.jobs = data;
        })

        $scope.deleteJob = function(index){
            jobService.deleteJob($scope.jobs[index].jobId);
            $scope.jobs.splice(index,1);
        }
        $scope.addJob = function(){
            jobService.addJob($scope.jobDto).then(function(data){
                $scope.jobs.push(data);
            })
        }
        $scope.updateJob = function(index, action){
            $scope.jobs[index].updateAction = action;
            jobService.updateJob($scope.jobs[index]).then(function(data){
                $scope.jobs[index] = data;
            })
        }
    });
