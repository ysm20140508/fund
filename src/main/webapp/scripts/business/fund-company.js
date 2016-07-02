var channelApp = angular.module('channelApp', []);
channelApp.controller('fund-company', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    $scope.items = null;
    $scope.result = null;
    $scope.queryForm = null;
    $scope.form = null;

    $scope.query = function () {
        $http.post("/fund-company/query", angular.toJson($scope.queryForm))
            .success(function (data) {
                if (data.length == 0) {
                    layer.msg("结果集为空,请重新输入条件查询。。。", {icon: 2})
                } else {
                    $scope.items = data;
                }
            })
    }

    $scope.edit = function (p) {
        layer_show('白名单编辑', '/fund-company/edit/init?id=' + p.id, '800', '500');
    }

    $scope.del = function (item) {
        layer.confirm("你确定要删除吗？", function () {
            $http.post('/fund-company/delete', angular.toJson(item))
                .success(function (data) {
                    if (data.result == 0) {
                        layer.msg("删除成功", {icon: 1}, function () {
                            window.location = '/fund-company';
                        })
                    } else {
                        layer.msg("删除失败", {icon: 2});
                    }
                })
        })
    }
    $scope.query();
}])
