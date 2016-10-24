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
}).controller('fund-new', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    $scope.items = null;
    $scope.result = null;
    $scope.queryForm = null;
    $scope.form = null;


    $scope.update = function (p) {
        $http.get('/fund-new/update?id=' + p.id);
        window.location = '/fund-new';
    }

    $scope.query = function () {
        $http.post("/fund-new/query", angular.toJson($scope.queryForm))
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
