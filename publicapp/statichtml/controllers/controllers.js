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
    .controller('applyCtrl', function ($scope, $routeParams, applicationService) {
        $scope.param = $routeParams.param;

        $scope.postApplication = function(){
            console.log("post");
            applicationService.postApplication().then(function(data){
                console.log(data);
            });
        }
    });