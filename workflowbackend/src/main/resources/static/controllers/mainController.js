angular.module('workflowApp')
    .controller('mainCtrl', function ($scope, $rootScope) {
        $scope.$on("updateJobs", function(evt, data){
            $scope.$broadcast("jobsUpdated","message");
        })
        $scope.$on("applicantsUpdated", function(evt, data){
            $scope.$broadcast("updateApplicants","message");
        })

        $scope.$on("applicationsUpdate", function(evt, data){
            $scope.$broadcast("updateApplications","message");
        })
        $scope.$on("applicationjobs", function(evt, data){
            $scope.$broadcast("applicationsUpdated","message");
        })
        $scope.$on("reviewerUpdated", function(evt, data){
            $scope.$broadcast("updateReviewers","message");
        })
    });
