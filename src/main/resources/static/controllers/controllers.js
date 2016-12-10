angular.module('workflowApp')
    .controller('workflowCtrl', function ($scope, applicationService, jobService, applicantService) {
        applications = [];
        jobs = [];
        applicants = [];

        applicationService.getApplications().then(function(data){
            $scope.applications = data;
            console.log(data);
        })
        jobService.getJobs().then(function(data){
            $scope.jobs = data;
            console.log(data);
        })
        applicantService.getApplicants().then(function(data){
            $scope.applicants = data;
            console.log(data);
        })
    })
