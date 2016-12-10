angular.module('workflowApp')
    .controller('workflowCtrl', function ($scope, applicationService, jobService, applicantService) {
        applications = [];
        jobs = [];
        applicants = [];
        applicantDto = {};
        applicationService.getApplications().then(function(data){
//            $scope.applications = data;
            console.log(data);
        })

        $scope.deleteApplication = function(index){
            console.log(index);
            applicationService.deleteApplication($scope.applications[index].applicationId);
            $scope.applications.splice(index,1);
        }
        $scope.deleteJob = function(index){
            console.log(index);
            jobService.deleteJob($scope.jobs[index].jobId);
            $scope.jobs.splice(index,1);
        }
        $scope.deleteApplicant = function(index){
            console.log(index);
            applicantService.deleteApplicant($scope.applicants[index].applicantId);
            $scope.applicants.splice(index,1);
        }
        jobService.getJobs().then(function(data){
            $scope.jobs = data;
            console.log(data);
        })
        applicantService.getApplicants().then(function(data){
            $scope.applicants = data;
            console.log(data);
        })

        $scope.addApplicant = function(){
            applicantService.addApplicant($scope.applicantDto).then(function(data){
                console.log(data);
                $scope.applicants.push(data);
            });

        }
    })
