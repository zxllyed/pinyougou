app.controller('brandController', function ($scope, $controller, brandService) {

    //继承baseController
    $controller('baseController', {$scope: $scope});//继承

    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };

    $scope.findPage = function (page, rows) {
        brandService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                // 更新总记录数
                $scope.paginationConf.totalItems = response.total;
            }
        );
    };

    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };

    $scope.save = function () {
        var serviceObject;
        if ($scope.entity.id != null) {
            serviceObject = brandService.update($scope.entity);
        } else {
            serviceObject = brandService.add($scope.entity);
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    };

    $scope.delete = function () {
        brandService.delete($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                    $scope.selectIds = [];
                }
            }
        );
    };

    // 定义的搜索对象
    $scope.searchEntity = {};

    $scope.search = function (page, rows) {
        brandService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                // 获取数据列表
                $scope.list = response.rows;
                // 更新总记录数
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }
});