angular.module('workflowApp')
    .controller('reviewCtrl', function ($scope, reviewService) {
        reviews = [];
        $scope.review = {};
        reviewService.getReviews().then(function(data){
            $scope.reviews = data;
        })

        $scope.addReview = function(){
            reviewService.addReview($scope.review).then(function(data){
                $scope.reviews.push(data);
            });
        }

    })
