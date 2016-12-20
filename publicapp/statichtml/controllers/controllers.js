angular.module('vacancyApp')
    .controller('vacancyCtrl', function ($scope, vacancyService, companyService, advertService) {

        vacancies = [];
        companies = [];
        adverts = [];
        vacancyService.getVacancies().then(function(data){
            console.log(data);
            $scope.vacancies = data;
        });
        companyService.getCompanies().then(function(data){
            console.log(data);
            $scope.companies = data;
        });
        advertService.getAdverts().then(function(data){
            console.log(data);
            $scope.adverts = data;
        });



    })
