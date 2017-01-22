angular.module('workflowApp')
    .controller('applicantCtrl', function ($scope, applicationService, jobService, applicantService) {
            applicants = [];
            $scope.applicantDto = {};
            $scope.deleteApplicant = function(index){
                applicantService.deleteApplicant($scope.applicants[index].applicantId);
                $scope.applicants.splice(index,1);

            }
            applicantService.getApplicants().then(function(data){
                $scope.applicants = data;
            })
            $scope.addApplicant = function(){
                applicantService.addApplicant($scope.applicantDto).then(function(data){
                    $scope.applicants.push(data);
                });
            }
        })
