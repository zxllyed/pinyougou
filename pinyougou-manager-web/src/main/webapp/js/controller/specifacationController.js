app.controller('specificationController', function ($scope, $controller, specificationService) {

    //继承baseController
    $controller('baseController', {$scope: $scope});

    // 定义的搜索对象
    $scope.searchEntity = {};

    $scope.search = function (page, rows) {
        specificationService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                // 获取数据列表
                $scope.list = response.rows;
                // 更新总记录数
                $scope.paginationConf.totalItems = response.total;
            }
        );
    };

    $scope.findAll = function () {
        specificationService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };

    $scope.delete = function () {
        specificationService.delete($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                    $scope.selectIds = [];
                }
            }
        );
    };

    $scope.findOne = function (id) {
        specificationService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    };

    // $scope.entity = {specificationOptionList: []};

    // 增加规格选项行
    $scope.addTableRow = function () {
        $scope.entity.specificationOptionList.push({});
    };

    // 删除规格选项行
    $scope.deleTableRow = function (index) {
        $scope.entity.specificationOptionList.splice(index, 1)
    };

    $scope.save = function () {
        var serviceObject;
        if ($scope.entity.specification.id != null) {
            serviceObject = specificationService.update($scope.entity);
        } else {
            serviceObject = specificationService.add($scope.entity);
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    //重新查询
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    }
});