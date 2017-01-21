angular.module('workflowApp')
    .controller('applicationCtrl', function ($scope, applicationService, jobService, applicantService) {
        applications = [];
        $scope.application = {};
        $scope.application.startState = "normal";
        jobs = [];
        applicants = [];
        $scope.applicationMessages = [];
        applicationsMessagesShow = false;

        $scope.getApplicants = function(){
            applicantService.getApplicants().then(function(data){
                $scope.applicants = data;
            })
        }

        $scope.getJobs = function(){
            jobService.getJobs().then(function(data){
                $scope.jobs = data;
            })
        }
        $scope.$on("jobsUpdated", function(evt, data){
            $scope.getJobs();
        })
        $scope.$on("updateApplicants", function(evt, data){
            $scope.getApplicants();
        })

        $scope.getJobs();
        $scope.getApplicants();
        applicationService.getApplications().then(function(data){
            $scope.applications = data;
        })

        $scope.addApplication = function(){
            applicationService.addApplication($scope.application).then(function(data){
                $scope.applications.push(data);
                $scope.applicationMessages.push("Application Added");
                applicationsMessagesShow = true;
                $scope.$emit("applicationsUpdate","appsupdate")
            });
        }

        $scope.deleteApplication = function(index){
            applicationService.deleteApplication($scope.applications[index].applicationId);
            $scope.applications.splice(index,1);
            $scope.applicationMessages.push("Application deleted");
            applicationsMessagesShow = true;
            $scope.$emit("applicationsUpdate","appsupdate")

        }

        $scope.removeappmessage = function(index){
            $scope.applicationMessages.splice(index,1);

        }

        $scope.updateApplication = function(index, action){
            $scope.applications[index].updateAction = action;
            applicationService.updateApplication($scope.applications[index]).then(function(data){
                $scope.applications[index] = data;
            })
        }
    });
