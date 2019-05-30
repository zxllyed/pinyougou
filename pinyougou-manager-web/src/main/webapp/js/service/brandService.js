app.service('brandService', function ($http) {

    // 全查品牌数据
    this.findAll = function () {
        return $http.get('../brand/findAll.do');
    };

    // 分页品牌
    this.findPage = function (page, rows) {
        return $http.get('../brand/findPage.do?page=' + page + '&rows=' + rows);
    };

    // 添加品牌
    this.add = function (entity) {
        return $http.post('../brand/add.do', entity);
    };

    // 更新品牌
    this.update = function (entity) {
        return $http.post('../brand/update.do', entity);
    };

    // 单查品牌
    this.findOne = function (id) {
        return $http.get('../brand/findOne.do?id=' + id);
    };

    // 删除品牌
    this.delete = function (ids) {
        return $http.get('../brand/delete.do?id=' + ids);
    };

    // 带条件分页查询品牌
    this.search = function (page, rows, searchEntity) {
        return $http.post('../brand/search.do?page=' + page + '&rows=' + rows, searchEntity);
    };
});