angular.module('workflowApp')
    .controller('jobDetailCtrl', function ($scope, applicationService, jobService, applicantService, $routeParams) {
        $scope.jobId = $routeParams.param;
        $scope.job = {};

        jobService.getJob($scope.jobId).then(function(data){
            $scope.job = data;
        })
    });
