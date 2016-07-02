var channelApp = angular.module('channelApp', []);
channelApp.controller('role', ['$scope', '$http', function ($scope, $http) {
    $scope.form = null;
    $scope.roles = null;
    $scope.flag = false;
    $scope.tips = null;
    $scope.createRole = null;
   // $scope.result = null;

    $scope.query = function () {
        console.log('role query:' + angular.toJson($scope.form));
        $http.post('/role/query', angular.toJson($scope.form))
            .success(function (data) {
                $scope.roles = data;
                console.log('role query result:' + angular.toJson($scope.roles));
            }).error(function (data) {
            $scope.flag = true;
            $scope.tips = "服务端错误,请联系管理员.";
        });
    }

    $scope.create = function () {
        console.log('role create:' + angular.toJson($scope.createRole));

        $http.post('/role/create', angular.toJson($scope.createRole))
            .success(function (data) {
                console.log('role create result:' + angular.toJson(data));
                $scope.flag = true;
                $scope.tips = data.msg;
            })
    }
    $scope.query();
}]);
