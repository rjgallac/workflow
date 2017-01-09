angular.module('workflowApp')
    .controller('applicationCtrl', function ($scope, applicationService, jobService, applicantService) {
        applications = [];
        $scope.application = {};
        $scope.application.startState = "normal";
        jobs = [];
        applicants = [];

        $scope.$on("apps", function(evt, data){
            $scope.getJobs();
            $scope.getApplicants();
        })


        $scope.getJobs = function(){
            jobService.getJobs().then(function(data){
                $scope.jobs = data;
            })
        }

        $scope.getApplicants = function(){
            applicantService.getApplicants().then(function(data){
                $scope.applicants = data;
            })
        }
        $scope.getJobs();
        $scope.getApplicants();
        applicationService.getApplications().then(function(data){
            $scope.applications = data;
        })

        $scope.addApplication = function(){
            applicationService.addApplication($scope.application).then(function(data){
                $scope.applications.push(data);
            });
        }

        $scope.deleteApplication = function(index){
            applicationService.deleteApplication($scope.applications[index].applicationId);
            $scope.applications.splice(index,1);
        }

        $scope.updateApplication = function(index, action){
            $scope.applications[index].updateAction = action;
            applicationService.updateApplication($scope.applications[index]).then(function(data){
                $scope.applications[index] = data;
            })
        }
    });
