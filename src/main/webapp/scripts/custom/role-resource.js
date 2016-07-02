var channelApp = angular.module('channelApp', []);


channelApp.controller('roleResource', ['$scope', '$http', function ($scope, $http) {
    $scope.role = null;
    $scope.roles = null;
    $scope.resources = null;

    //获取角色列表
    $scope.queryAllRoles = function () {
        console.log('queryAllRoles');
        $http.get('/role/query')
            .success(function (data) {
                console.log('result:' + angular.toJson(data));
                $scope.roles = data;
            })
    }

    $scope.query = function () {
        //向服务器端获取资源
        $http.post('/role/resource/query', angular.toJson($scope.role))
            .success(function (data) {
                console.log('result:' + angular.toJson($scope.role));
                $scope.resources = data;
            })
    }

    $scope.changeQueryOperate = function (resource) {
        resource.operate.query = "1";
    }

    $scope.save = function () {
        if (null == $scope.role) {
            layer.msg("请选择角色", {shift: 6}
                , function () {
                    layer.closeAll();
                }
            )
        } else {
            //向服务器端保存
            $scope.role.resources = $scope.resources;
            $http.post('/role/resource/edit', angular.toJson($scope.role))
                .success(function (data) {
                    console.log('result:' + angular.toJson($scope.role));
                    if (data.result == 0) {
                        layer.msg("保存成功", {icon: 1})
                        $scope.query();
                    } else {
                        layer.msg(data.msg, {shift: 6}
                            , function () {
                                layer.closeAll();
                            }
                        )
                    }
                })
        }
    }

    $scope.queryAllRoles();
    $scope.query();
}]);
