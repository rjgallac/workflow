angular.module('workflowApp')
    .controller('reviewerCtrl', function ($scope, reviewerService) {
        reviewers = [];
        $scope.reviewer = {};
        reviewerService.getReviewers().then(function(data){
            $scope.reviewers = data;
        })

        $scope.addReviewer = function(){
            reviewerService.addReviewer($scope.reviewer).then(function(data){
                $scope.reviewers.push(data);
            });
        }

    })
