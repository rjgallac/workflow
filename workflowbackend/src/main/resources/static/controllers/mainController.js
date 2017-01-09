angular.module('workflowApp')
    .controller('mainCtrl', function ($scope, $rootScope) {
        $scope.$on("updateapps", function(evt, data){
            $scope.$broadcast("apps","message");
        })
    });
