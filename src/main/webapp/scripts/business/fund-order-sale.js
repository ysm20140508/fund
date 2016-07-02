var channelApp = angular.module('channelApp', []);
channelApp.controller('fund-order-sale', ['$scope', '$http', '$location', function ($scope, $http, $location) {
    $scope.result = null;
    $scope.form = null;
    $scope.funds = null;

    $scope.sale = function () {
        $http.post('/fund-order/sale', angular.toJson($scope.form))
            .success(function (data) {
                if (data.result == 0) {
                    layer.msg("卖出成功", {icon: 1}, function () {
                        layer.closeAll();
                    })
                } else {
                    layer.msg("卖出失败 请重新编辑", {icon: 6}, function () {
                        layer.closeAll();
                    })
                }
            })
    }

    $scope.find = function () {
        var id = document.getElementById("id");
        $http.get('/fund-order/find?id=' + id.value)
            .success(function (data) {
                $scope.form = data;
                console.log("result---" + angular.toJson($scope.form))
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    }

    $scope.queryFunds = function () {
        $http.get('/fund/list')
            .success(function (data) {
                $scope.funds = data;
            });
    }

    $scope.find();
    $scope.queryFunds();
}])
