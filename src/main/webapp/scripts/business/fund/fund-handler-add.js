var channelApp = angular.module('channelApp', []);
channelApp.controller('fund-handler-add', ['$scope', '$http', '$location', function ($scope, $http, $location) {

    $scope.items = null;
    $scope.result = null;
    $scope.form = null;
    $scope.fundCompanys = null;

    $scope.create = function () {
        $http.post('/fund-handler/create', angular.toJson($scope.form))
            .success(function (data) {
                if (data.result == 0) {
                    layer.msg("新增成功", {icon: 1}, function () {
                        window.location='/fund-handler';
                        layer.closeAll();
                    })
                } else {
                    layer.msg("添加失败 请重新添加", {icon: 6}, function () {
                        window.location='/fund-handler';
                        layer.closeAll();
                    })
                }
                layer.msg(data.msg, {icon: 1, time: 1000}, function () {
                    layer_close();
                });
            })
    }

    $scope.queryFundCompanys = function(){
        $http.get('/fund-company/list')
            .success(function(data){
                $scope.fundCompanys=data;
            });
    };

    $scope.queryFundCompanys();
}])
