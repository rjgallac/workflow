angular.module('workflowApp')
    .controller('reviewCtrl', function ($scope, reviewService, reviewerService, applicationService) {
        reviews = [];
        $scope.review = {};
        reviewers = [];
        applications = [];

        $scope.getApplications = function(){
            applicationService.getApplications().then(function(data){
                $scope.applications = data;
            })
        }
        $scope.getApplications();

        $scope.$on("updateApplications", function(evt, data){
            $scope.getApplications();
        })


        $scope.$on("updateReviewers", function(evt, data){
            $scope.getReviewers();
        })

        reviewService.getReviews().then(function(data){
            $scope.reviews = data;
        })
        $scope.getReviewers = function(){
            reviewerService.getReviewers().then(function(data){
                $scope.reviewers = data;
            })
        }
        $scope.getReviewers();

        $scope.addReview = function(){
            reviewService.addReview($scope.review).then(function(data){
                $scope.reviews.push(data);
            });
        }
        $scope.deleteReview = function(index){
            reviewService.deleteReview($scope.reviews[index].reviewId).then(function(data){
                $scope.reviews.splice(index,1);
            });
        }


    })
