angular.module('workflowApp')
    .controller('reviewerCtrl', function ($scope, reviewerService) {
        reviewers = [];
        $scope.reviewer = {};

        $scope.$on("updateReviewers", function(evt, data){
            $scope.getReviewers();
        })

        $scope.getReviewers = function(){
            reviewerService.getReviewers().then(function(data){
                $scope.reviewers = data;
            })
        }

        $scope.getReviewers();

        $scope.addReviewer = function(){
            reviewerService.addReviewer($scope.reviewer).then(function(data){
                $scope.reviewers.push(data);
                $scope.$emit("reviewerUpdated","appsupdate")
            });
        }

        $scope.deleteReviewer = function(index){
            reviewerService.deleteReviewer($scope.reviewers[index].reviewerId).then(function(data){
                $scope.reviewers.splice(index,1);
                $scope.$emit("reviewerUpdated","appsupdate")
            });
        }

    })
