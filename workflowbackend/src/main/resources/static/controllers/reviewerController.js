angular.module('workflowApp')
    .controller('reviewerCtrl', function ($scope, reviewerService) {
        reviewers = [];
        $scope.reviewer = {};
        reviewerService.getReviewers().then(function(data){
            $scope.reviewers = data;
            console.log(data);
        })

        $scope.addReviewer = function(){
            console.log("add reviewer");
            reviewerService.addReviewer($scope.reviewer).then(function(data){
                $scope.reviewers.push(data);
            });
        }

    })
