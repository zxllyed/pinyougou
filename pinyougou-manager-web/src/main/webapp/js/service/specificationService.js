app.service('specificationService', function ($http) {

    // 返回全部规格列表
    this.findAll = function () {
        return $http.get('../specification/findAll.do');
    };

    // 带条件分页查询规格
    this.search = function (page, rows, searchEntity) {
        return $http.post('../specification/search.do?page=' + page + '&rows=' + rows, searchEntity);
    };

    this.findOne = function (id) {
        return $http.get('../specification/findOne.do?id=' + id);
    };

    this.delete = function (ids) {
        return $http.get('../specification/delete.do?ids=' + ids);
    };

    this.add = function (entity) {
        return $http.post('../specification/add.do', entity);
    };

    this.update = function (entity) {
        return $http.post('../specification/update.do', entity);
    }
});