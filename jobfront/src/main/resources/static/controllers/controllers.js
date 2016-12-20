angular.module('vacancyApp')
    .controller('vacancyCtrl', function ($scope, vacancyService) {

        vacancies = [];

        vacancyService.getVacancies().then(function(data){
            console.log(data);
            $scope.vacancies = data;
        });




    })
