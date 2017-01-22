angular.module('workflowApp')
    .controller('applicantDetailCtrl', function ($scope, applicationService, jobService, applicantService, $routeParams) {
        $scope.applicantId = $routeParams.param;
        $scope.applicant = {};

        applicantService.getApplicant($scope.applicantId).then(function(data){
            $scope.applicant = data
        })
    });
