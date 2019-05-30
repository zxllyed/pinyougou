app.controller('baseController', function ($scope) {
    //重新加载列表 数据
    $scope.reloadList = function () {
        //切换页码
        $scope.search(
            $scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage
        );
    };

    //分页控件配置
    $scope.paginationConf = {
        // 当前页码
        currentPage: 1,
        // 总条数
        totalItems: 10,
        itemsPerPage: 10,
        // 页码选项
        perPageOptions: [10, 20, 30, 40, 50],
        // 更改页面时触发事件
        onChange: function () {
            $scope.reloadList();
        }
    };

    //定义id集合
    $scope.selectIds = [];

    // 更新复选
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);
        }
    };
});