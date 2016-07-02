var channelApp = angular.module('channelApp', []);
channelApp.controller('userCtlr', ['$scope', '$http', function ($scope, $http) {
    $scope.form = null;
    $scope.users = null;
    $scope.flag = false;
    $scope.tips = null;
//  $scope.isActive=null;
    $scope.roles = null;
    $scope.parents = null;
    /**
     * 初始化查询
     */
    $scope.query = function () {
        $http.post('/user/query', angular.toJson($scope.form))
            .success(function (data) {
                $scope.users = data;
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    }

    $scope.edit = function (user) {
        layer_show('用户编辑', '/user/edit/init?id=' + user.id, '800', '500');
    }

    $scope.roleList = function () {
        $http.get('/role/query').success(function (data) {
            $scope.roles = data;
        });
    }
    $scope.parentsList = function () {
        $http.get('/parent/list').success(function (data) {
            $scope.parents = data;
            console.log("parent result:" + angular.toJSON(data))
        });

    }
    $scope.parentsList();
    $scope.query();
    $scope.roleList();
    /**
     * 删除用户
     * @param user
     * @param obj
     */
    $scope.delete = function (user, obj) {
        layer.confirm('确认要删除吗？', function () {
            $http.post('/user/delete', angular.toJson(user))
                .success(function (data) {
                    $scope.result = data
                    if ($scope.result.result == 0) {
                        layer.msg("删除成功", {icon: 1}, function () {
                            $scope.query();
                        })
                    } else {
                        layer.msg("系统异常删除失败", {shift: 6}
                            , function () {
                                layer.closeAll();
                            }
                        )
                    }
                })
        });
    }
    /**
     * 用户启用
     */
    $scope.user_start = function (user) {
        layer.confirm('确认要启用吗？', function () {
            $http.post("/user/startUser", angular.toJson(user))
                .success(function (data) {
                    $scope.result = data
                    if ($scope.result.result == 0) {
                        layer.msg("启用成成功", {icon: 1})
                        $scope.query();
                    } else {
                        layer.msg("系统异常启用失败", {shift: 6}
                            , function () {
                                layer.closeAll();
                            }
                        )
                    }
                })
        });
    }
    /**
     * 显示添加用户
     */
    $scope.user_add = function () {
        layer_show('添加用户', '/user/add/init', '800', '500');
    }
}]);
