angular.module('workflowApp')
    .controller('applicationDetailCtrl', function ($scope, applicationService, jobService, applicantService, $routeParams) {
        $scope.applicationId = $routeParams.param;
        $scope.application = {};

        applicationService.getApplication($scope.applicationId).then(function(data){
            console.log(data);
            console.log("here");
            $scope.application = data
        })
    });
