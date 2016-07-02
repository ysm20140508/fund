var channelApp = angular.module('channelApp', []);
channelApp.controller('admin_add', ['$scope', '$http', function ($scope, $http) {
    $scope.form = null;
    $scope.roles = null;
    $scope.result = null;
    $scope.flag = null;
    $scope.tips = null;
    $scope.showflag = false;

    $scope.parents = null;

    $scope.parentsList = function () {
        $http.get('/parent/list').success(function (data) {
            $scope.parents = data;

        });

    }
    $scope.parentsList();


    /**
     * 验证输入
     */
    $scope.validName = function () {
        $http.post('/user/query', angular.toJson($scope.form))
            .success(function (data) {
                $scope.result = data;
                if ($scope.result.result == 1) {
                    $scope.flag = "该账号以存在";
                    $scope.showflag = true;
                }
            })

    }

    $scope.textfocus = function () {
        $scope.showflag = false;

    }

    /**
     * 获取所有角色
     */


    $scope.roleList = function () {
        $http.get('/role/query').success(function (data) {
            $scope.roles = data;
        });

    }
    $scope.roleList();


    /**
     * 创建用户
     * @param isValid
     */
    $scope.createUser = function () {
        $http.post('/user/create', angular.toJson($scope.form))
            .success(function (data) {
                if (data.result == 0) {
                    window.location = '/user';
                    layer.msg("新增成功", {icon: 1}, function () {
                        layer.closeAll();
                    })
                } else {
                    window.location = '/user';
                    layer.msg("新增失败", {icon: 1}, function () {
                        layer.closeAll();
                    })
                }
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    };
}]);
