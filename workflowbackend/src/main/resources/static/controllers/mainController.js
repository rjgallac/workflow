angular.module('workflowApp')
    .controller('mainCtrl', function ($scope, $rootScope) {
        $scope.$on("updateapps", function(evt, data){
            console.log("HERE");
            $scope.$broadcast("apps","message");
        })
    });
