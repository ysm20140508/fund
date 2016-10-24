var channelApp = angular.module('channelApp', []);
channelApp.controller('fund-order-add', ['$scope', '$http', '$location', function ($scope, $http, $location) {

    $scope.items = null;
    $scope.result = null;
    $scope.form = null;
    $scope.funds = null;

    $scope.create = function () {
        $http.post('/fund-order/create', angular.toJson($scope.form))
            .success(function (data) {
                if (data.result == 0) {
                    layer.msg("新增成功", {icon: 1}, function () {
                        window.location = '/fund-order';
                        layer.closeAll();
                    })
                } else {
                    layer.msg("添加失败 请重新添加", {icon: 6}, function () {
                        window.location = '/fund-order';
                        layer.closeAll();
                    })
                }
                layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                    layer_close();
                });
            })
    }

    $scope.queryFunds = function () {
        $http.get('/fund/list')
            .success(function (data) {
                $scope.funds = data;
            });
    }

    $scope.queryFunds();
}])
