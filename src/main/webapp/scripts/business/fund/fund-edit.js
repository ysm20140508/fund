var channelApp = angular.module('channelApp', []);
channelApp.controller('fund-edit', ['$scope', '$http', '$location', function ($scope, $http, $location) {
    $scope.result = null;
    $scope.form = null;
    $scope.fundHandlers = null;
    $scope.fundCompanys = null;

    $scope.edit = function () {
        $http.post('/fund/edit', angular.toJson($scope.form))
            .success(function (data) {
                if (data.result == 0) {
                    layer.msg("编辑成功", {icon: 1}, function () {
                        window.location='/fund';
                        layer.closeAll();
                    })
                } else {
                    layer.msg("编辑失败 请重新编辑", {icon: 6}, function () {
                        window.location='/fund';
                        layer.closeAll();
                    })
                }
                layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                    layer_close();
                });
            })
    }

    $scope.find = function () {
        var id = document.getElementById("id");
        $http.get('/fund/find?id=' + id.value)
            .success(function (data) {
                $scope.form = data;
                console.log("result---" + angular.toJson($scope.form))
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    }

    $scope.queryFundCompanys = function () {
        $http.get('/fund-company/list')
            .success(function (data) {
                $scope.fundCompanys = data;
            });
    }

    $scope.queryFundHandlers = function () {
        $http.get('/fund-handler/list')
            .success(function (data) {
                $scope.fundHandlers = data;
            });
    }

    $scope.queryFundHandlers();
    $scope.queryFundCompanys();
    $scope.find();
}])
