var channelApp = angular.module('channelApp', []);


channelApp.controller('resource', ['$scope', '$document', '$http', function ($scope, $document, $http) {
    $scope.form = null;
    $scope.resources = null;
    $scope.flag = false;
    $scope.tips = null;
    $scope.createResource = null;
    $scope.parentResources = null;
    $scope.currentResource = null;

    $scope.queryParent = function () {
        $http.post('/resource/query/parent')
            .success(function (data) {
                $scope.parentResources = data;
                console.log('query result:' + angular.toJson($scope.parentResources));
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    }

    $scope.query = function () {
        console.log('query:' + angular.toJson($scope.form));
        $http.post('/resource/query', angular.toJson($scope.form))
            .success(function (data) {
                $scope.resources = data;
                console.log('query result:' + angular.toJson($scope.resources));
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    }

    $scope.getCurrentData = function (id) {
        console.log('query:' + id);
        $http.post('/resource/find', id)
            .success(function (data) {
                $scope.currentResource = data;
                console.log('query result:' + angular.toJson($scope.currentResource));
            }).error(function (data) {
                $scope.flag = true;
                $scope.tips = "服务端错误,请联系管理员.";
            });
    }

    $scope.create = function () {
        console.log('create:' + angular.toJson($scope.createResource));

        $http.post('/resource/create', angular.toJson($scope.createResource))
            .success(function (data) {
                console.log('create result:' + angular.toJson(data));
                window.location = '/resource';
            })
    }

    $scope.edit = function (resource) {
        console.log('edit:' + angular.toJson(resource));
        $scope.currentResource = resource;

        admin_edit('资源编辑', '/resource/edit/init?id=' + resource.id, '1', '800', '500');
    }


    $scope.delete = function (resource) {
        layer.confirm('确认要删除吗？', function () {
            console.log('delete:' + angular.toJson(resource));
            $scope.currentResource = resource;
            $http.post('/resource/delete', angular.toJson($scope.currentResource))
                .success(function (data) {
                    console.log('delete result:' + angular.toJson(data));
                    if (data.result == 0) {
                        layer.msg("删除成功", {icon: 1})
                        $scope.query();
                    } else {
                        layer.msg(data.msg, {shift: 6}
                            , function () {
                                layer.closeAll();
                            }
                        )
                    }
                })
        });
    }
    $scope.queryParent();
    $scope.query();
}]);
