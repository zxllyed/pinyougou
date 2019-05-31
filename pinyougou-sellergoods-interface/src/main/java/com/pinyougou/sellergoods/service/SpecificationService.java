package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojogroup.Specification;

import java.util.List;

public interface SpecificationService {

    /**
     * 带条件的规格分页查询
     *
     * @param tbSpecification
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbSpecification tbSpecification, int pageNum, int pageSize);

    /**
     * 批量删除规格
     *
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 查询单个实体类
     *
     * @param id
     * @return
     */
    public Specification findOne(Long id);

    /**
     * 添加规格组（规格+规格项）
     *
     * @param specification
     */
    public void add(Specification specification);

    /**
     * 更新规格
     *
     * @param specification
     */
    public void update(Specification specification);

    /**
     * 返回全部的规格列表
     *
     * @return、】
     */
    public List<TbSpecification> findAll();
}
