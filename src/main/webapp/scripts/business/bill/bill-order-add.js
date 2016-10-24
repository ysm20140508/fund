var channelApp = angular.module('channelApp', []);
channelApp.controller('bill-order-add', ['$scope', '$http', '$location', function ($scope, $http, $location) {

    $scope.items = null;
    $scope.result = null;
    $scope.form = null;

    $scope.create = function () {
        $http.post('/bill-order/create', angular.toJson($scope.form))
            .success(function (data) {
                if (data.result == 0) {
                    layer.msg("新增成功", {icon: 1}, function () {
                        window.location='/bill-order';
                        layer.closeAll();
                    })
                } else {
                    layer.msg("添加失败 请重新添加", {icon: 6}, function () {
                        window.location='/bill-order';
                        layer.closeAll();
                    })
                }
                layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                    layer_close();
                });
            })
    }

    $scope.queryGood= function () {
        $http.get('/bill-good/list')
            .success(function (data) {
                $scope.goods = data;
                console.log("result---" + angular.toJson($scope.form))
            }).error(function (data) {
            $scope.flag = true;
            $scope.tips = "服务端错误,请联系管理员.";
        });
    }

    $scope.queryGood();
}])
