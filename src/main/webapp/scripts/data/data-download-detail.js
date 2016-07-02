Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
var newDate = new Date().Format("yyyy-MM-dd");

var channelApp = angular.module('channelApp', []);
channelApp.filter('numberOrFormat', function () {
    return function (input) {
        if (input >= 0 && input < 10) {
            return "000" + input;
        } else if (input >= 10 && input < 100) {
            return "00" + input;
        } else if (input >= 100 && input < 1000) {
            return "0" + input;
        }
        return input;
    }
}).directive('wstDatepicker', function () {
    return {
        restrict: 'EA',
        replace: true,
        scope: {
            model: "=ngModel"
        },
        link: function (scope, element, attrs, ctrl) {
            $(element).datepicker({
                dateFormat: 'yy-MM-dd',
                changeMonth: false,
                changeYear: false,
                autoSize: true,
                showButtonPanel: true,
                onSelect: function (dateText, inst) {
                    scope.$apply(function () {
                        scope.model = dateText;
                    });
                }
            });
            $.datepicker._gotoToday = function (id) {
                var target = $(id);
                var inst = this._getInst(target[0]);
                if (this._get(inst, 'gotoCurrent') && inst.currentDay) {
                    inst.selectedDay = inst.currentDay;
                    inst.drawMonth = inst.selectedMonth = inst.currentMonth;
                    inst.drawYear = inst.selectedYear = inst.currentYear;
                }
                else {
                    var date = new Date();
                    inst.selectedDay = date.getDate();
                    inst.drawMonth = inst.selectedMonth = date.getMonth();
                    inst.drawYear = inst.selectedYear = date.getFullYear();
                    this._setDateDatepicker(target, date);
                    this._selectDate(id, this._getDateDatepicker(target));
                }
                this._notifyChange(inst);
                this._adjustDate(target);
            }
        }
    }
}).controller('query-strategy-request-items', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    $scope.items = null;
    $scope.result = null;
    $scope.form = null;
    $scope.business = null;
    $scope.channel = null;
    $scope.channelBusiness = null;
    $scope.appName=null;
    
    $scope.form = {
        startDate: newDate,
        endDate: newDate
    }

    $scope.query = function () {
    	$scope.items = null;
        $http.post("/query/downsucceed", angular.toJson($scope.form))
            .success(function (data) {
                if (data.length == 0) {
                    layer.msg("结果集为空,请重新输入条件查询。。。", {icon: 2})
                } else {
                    $scope.items = data;
                }
            })
    }
    $scope.channelBussiness = function () {
        $http.get('/user/queryByRoleId?roleId=35')
            .success(function (data) {
                $scope.channelBusiness = data;
            });
    }
    $scope.queryBusiness = function () {
        $http.get('/user/queryByRoleId?roleId=36')
            .success(function (data) {
                $scope.business = data;
            });
    }

    $scope.queryChannel = function () {
        $http.get('/channel/list')
            .success(function (data) {
                $scope.channel = data;
            });
    }
    
    $scope.queryappName=function()
    {
    	$http.get('/query/downsucceed')
        .success(function (data) {
            $scope.appName = data;
        });
    }
    
    $scope.queryBusiness();
    $scope.queryChannel();
    $scope.queryappName();
    $scope.channelBussiness();
    $scope.query();
}])
