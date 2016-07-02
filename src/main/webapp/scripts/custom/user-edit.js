/**
 * Created by yunva on 2016/1/25.
 */
var channelApp = angular.module('channelApp', []);
channelApp.controller('user_edit', ['$scope', '$http', function ($scope, $http) {
    $scope.parents = null;
    $scope.initializeVuale = null;
    $scope.roles = null;
    $scope.result = null;
    $scope.from = null;

    $scope.roleList = function () {
        $http.get('/role/query').success(function (data) {
            $scope.roles = data;
        });

    }
    $scope.parentsList = function () {
        $http.get('/parent/list').success(function (data) {
            $scope.parents = data;
            // console.log("parent result:"+angular.toJSON(data))
        });

    }
    $scope.initializeData = function () {
        var id = document.getElementById("id");
        $http.get('/user/edit/initializeVuale?id=' + id.value)
            .success(function (data) {
                $scope.from = data;
                console.log("result---" + angular.toJson($scope.initializeVuale))
            }).error(function (data) {
            $scope.flag = true;
            $scope.tips = "服务端错误,请联系管理员.";
        });

    }
    /*
     * 编辑用户
     */
    $scope.editUser = function () {
        $http.post('/user/edit', angular.toJson($scope.from))
            .success(function (data) {
                $scope.result = data;
                window.location='/user';
                layer.msg(data.msg, {icon: 1, time: 2000}, function () {
                    layer_close();
                });
            })
    }
    $scope.parentsList();
    $scope.roleList();
    $scope.initializeData();
}])
