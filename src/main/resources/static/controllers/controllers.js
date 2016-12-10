angular.module('workflowApp')
    .controller('workflowCtrl', function ($scope, workflowService) {
        applications = [];
        workflowService.getApplications().then(function(data){
            $scope.applications = data;
            console.log(data);
        })
    })
