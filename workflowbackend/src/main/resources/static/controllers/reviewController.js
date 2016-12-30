angular.module('workflowApp')
    .controller('reviewCtrl', function ($scope, reviewService, reviewerService, applicationService) {
        reviews = [];
        $scope.review = {};
        reviewers = [];
        applications = [];

        reviewService.getReviews().then(function(data){
            $scope.reviews = data;
        })
        reviewerService.getReviewers().then(function(data){
            $scope.reviewers = data;
        })
        $scope.addReview = function(){
            reviewService.addReview($scope.review).then(function(data){
                $scope.reviews.push(data);
            });
        }
        applicationService.getApplications().then(function(data){
            $scope.applications = data;
        })
    })
