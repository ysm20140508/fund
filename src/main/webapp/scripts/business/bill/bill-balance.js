var channelApp = angular.module('channelApp', []);
channelApp.controller('bill-balance', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    $scope.items = null;
    $scope.result = null;
    $scope.queryForm = null;
    $scope.form = null;

    $scope.query = function () {
        $http.post("/bill-balance/query", angular.toJson($scope.queryForm))
            .success(function (data) {
                if (data.length == 0) {
                    layer.msg("结果集为空,请重新输入条件查询。。。", {icon: 2})
                } else {
                    $scope.items = data;
                }
            })
    }
    $scope.query();
}])
