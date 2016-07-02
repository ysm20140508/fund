var channelApp = angular.module('channelApp', []);

channelApp.controller('userLogin', ['$scope', '$window', '$http', function ($scope, $window, $http) {
    $scope.user = null;
    $scope.result = null;
    $scope.flag = false;
    $scope.tips = null;


    $scope.login = function (isValid) {
        if (isValid) {
            console.log('user login:' + angular.toJson($scope.user));
            $scope.flag = false;
            $http.post('/user/login', $scope.user)
                .success(function (data) {
                    $scope.result = data;
                    console.log('user login result:' + angular.toJson($scope.result));
                    if ($scope.result.result == 0) {
                        //登陆成功
                        //$location.absUrl($scope.result.url);
                        //设置对应的商务,主管,业务员,
                        $http.post('/user/obtainrole');
                        //重定向
                        $window.location.href = $scope.result.url;
                    } else {
                        $scope.flag = true;
                        $scope.tips = '(' + $scope.result.result + ')' + $scope.result.msg;
                        layer.msg($scope.result.msg);
                    }
                }).error(function (data) {
                    $scope.flag = true;
                    $scope.tips = "服务端错误,请联系管理员.";
                });
        } else {
            console.log('user login failure:' + angular.toJson($scope.user));
        }
    };

    $scope.reset = function () {
        console.log('user reset:' + angular.toJson($scope.user));
        $scope.user = null;
    }
}]);
