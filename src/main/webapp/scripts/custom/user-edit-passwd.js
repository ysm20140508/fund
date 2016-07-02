/**
 * Created by yunva on 2016/1/25.
 */
var channelApp = angular.module('channelApp', []);
/* 密码验证 */
channelApp.directive("passVerify", function () {
    return {
        link: function (scope, element, attrs, ctrl) {
            var newpas = '#' + attrs.passVerify;
            $(element).add(newpas).on("keyup", function () {
                scope.$apply(function () {
                    var v = element.val() == $(newpas).val();
                    scope.userForm.passwd.$setValidity('ng-invalid', v);
                });
            });
        }
    }
}).controller('user_edit_passwd', ['$scope', '$http', '$window', function ($scope, $http, $window) {
    $scope.parents = null;
    $scope.form = null;
    $scope.passwd = null;
    /*
     * 编辑用户
     */
    $scope.editPasswd = function (isValid) {
        if (!isValid) {
            layer.msg("密码不一致,请重新输入", {icon: 1}, function () {
            })
            return;
        }
        $http.post('/user/edit-passwd', angular.toJson($scope.form))
            .success(function (data) {
                if (data.result == 0) {
                    layer.msg("修改密码成功", {icon: 1}, function () {
                        //$window.location.href = '/main';
                        layer.closeAll();
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    })
                } else if (data.result == 5) {
                    layer.msg("密码错误", {icon: 1}, function () {
                        //$window.location.href = '/main';
                        layer.closeAll();
                    })
                } else {
                    layer.msg("修改密码失败", {icon: 1}, function () {
                        //$window.location.href = '/main';
                        layer.closeAll();
                    })
                }
            })
    }
}])
