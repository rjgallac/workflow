angular.module('workflowApp')
    .controller('workflowCtrl', function ($scope, applicationService, jobService, applicantService) {
        applications = [];
        jobs = [];
        applicants = [];
        $scope.application = {};
        $scope.application.startState = "normal";
        applicantDto = {};
        jobDto = {};
        applicationService.getApplications().then(function(data){
            $scope.applications = data;
            console.log(data);
        })

        $scope.addApplication = function(){
            console.log($scope.application);
            applicationService.addApplication($scope.application).then(function(data){
                $scope.applications.push(data);
            });
        }

        $scope.deleteApplication = function(index){
            console.log(index);
            applicationService.deleteApplication($scope.applications[index].applicationId);
            $scope.applications.splice(index,1);
        }

        $scope.updateApplication = function(index, action){
            console.log("udating"+index);
            $scope.applications[index].updateAction = action;
            console.log($scope.applications[index]);
            applicationService.updateApplication($scope.applications[index]).then(function(data){
                $scope.applications[index] = data;
            })
        }


        $scope.deleteApplicant = function(index){
            console.log(index);
            applicantService.deleteApplicant($scope.applicants[index].applicantId);
            $scope.applicants.splice(index,1);
        }
        jobService.getJobs().then(function(data){
            $scope.jobs = data;
            console.log(data);
        })

        $scope.deleteJob = function(index){
            console.log(index);
            jobService.deleteJob($scope.jobs[index].jobId);
            $scope.jobs.splice(index,1);
        }
        $scope.addJob = function(){
            console.log("adding job");
            jobService.addJob($scope.jobDto).then(function(data){
                $scope.jobs.push(data);
            })
        }
        applicantService.getApplicants().then(function(data){
            $scope.applicants = data;
            console.log(data);
        })

        $scope.addApplicant = function(){
            applicantService.addApplicant($scope.applicantDto).then(function(data){
                console.log(data);
                $scope.applicants.push(data);
            });

        }
    })
