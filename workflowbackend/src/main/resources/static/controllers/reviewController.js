angular.module('workflowApp')
    .controller('reviewCtrl', function ($scope, reviewService) {
        reviews = [];
        $scope.review = {};
        reviewService.getReviews().then(function(data){
            $scope.reviews = data;
            console.log(data);
        })

        $scope.addReview = function(){
            console.log("add review");
            reviewService.addReview($scope.review).then(function(data){
                $scope.reviews.push(data);
            });
        }

    })
