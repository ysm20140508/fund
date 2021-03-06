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
}).controller('fund', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    $scope.items = null;
    $scope.result = null;
    $scope.queryForm = null;
    $scope.form = null;

    $scope.query = function () {
        $http.post("/fund/query", angular.toJson($scope.queryForm))
            .success(function (data) {
                if (data.length == 0) {
                    layer.msg("结果集为空,请重新输入条件查询。。。", {icon: 2})
                } else {
                    $scope.items = data;
                }
            })
    }

    $scope.edit = function (p) {
        layer_show('基金编辑', '/fund/edit/init?id=' + p.code, '800', '500');
    }

    $scope.lineChart=function(p){
        layer_show('', '/fund/lineChart/init?id=' + p.code, '800', '500');
    }

    $scope.del = function (item) {
        layer.confirm("你确定要删除吗？", function () {
            $http.post('/fund/delete', angular.toJson(item))
                .success(function (data) {
                    if (data.result == 0) {
                        layer.msg("删除成功", {icon: 1}, function () {
                            window.location = '/fund';
                        })
                    } else {
                        layer.msg("删除失败", {icon: 2});
                    }
                })
        })
    }
    $scope.query();
}])
