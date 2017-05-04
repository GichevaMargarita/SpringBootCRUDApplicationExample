var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootCRUDApp',
    USER_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/student/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'StudentController',
                controllerAs:'ctrl',
                resolve: {
                    students: function ($q, StudentService) {
                        console.log('Load all students');
                        var deferred = $q.defer();
                        StudentService.loadAllStudents().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);