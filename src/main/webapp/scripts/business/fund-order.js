var channelApp = angular.module('channelApp', []);
channelApp.filter('numberOrFormat', function () {
    return function (input) {
        if (input >= 0 && input < 10) {
            return "00000" + input;
        } else if (input >= 10 && input < 100) {
            return "0000" + input;
        } else if (input >= 100 && input < 1000) {
            return "000" + input;
        } else if (input >= 1000 && input < 10000) {
            return "00" + input;
        } else if (input >= 10000 && input < 100000) {
            return "0" + input;
        }
        return input;
    }
}).controller('fund-order', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    $scope.items = null;
    $scope.result = null;
    $scope.queryForm = null;
    $scope.form = null;

    $scope.query = function () {
        $http.post("/fund-order/query", angular.toJson($scope.queryForm))
            .success(function (data) {
                if (data.length == 0) {
                    layer.msg("结果集为空,请重新输入条件查询。。。", {icon: 2})
                } else {
                    $scope.items = data;
                }
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    }

    $scope.edit = function (p) {
        layer_show('白名单编辑', '/fund-order/edit/init?id=' + p.id, '800', '500');
    }

    $scope.sale = function (p) {
        layer.open({
            type: 2,
            area: ['510' + 'px', '410' + 'px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: '卖出',
            content: '/fund-order/sale/init?id=' + p.id
        })
    }
    $scope.query();
}])
