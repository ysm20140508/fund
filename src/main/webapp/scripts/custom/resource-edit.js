var channelApp = angular.module('channelApp', []);


channelApp.controller('resource', ['$scope', '$document', '$http', function ($scope, $document, $http) {
    $scope.resources = null;
    $scope.flag = false;
    $scope.tips = null;
    $scope.currentResource = null;

    $scope.queryParent = function () {
        $http.post('/resource/query/parent')
            .success(function (data) {
                $scope.parentResources = data;
                console.log('query result:' + angular.toJson($scope.parentResources));
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    }

    $scope.getCurrentData = function () {
        var id = document.getElementById("id");
        console.log('find:' + id.value);
        $http.get('/resource/find?id=' + id.value)
            .success(function (data) {
                $scope.currentResource = data;
                console.log('find result:' + angular.toJson($scope.currentResource));
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    }


    $scope.edit = function () {
        $http.post('/resource/edit', angular.toJson($scope.currentResource))
            .success(function (data) {
                console.log('delete result:' + angular.toJson(data));
                window.location = '/resource';
                layer.msg('编辑成功', {icon: 1, time: 2000}, function () {
                    layer_close();
                });
            })
    }

    $scope.queryParent();
    $scope.getCurrentData();
}]);
