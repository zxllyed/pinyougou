package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbSpecification;

public interface SpecificationService {

    /**
     * 带条件的规格分页查询
     * @param tbSpecification
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbSpecification tbSpecification, int pageNum, int pageSize);

    /**
     * 批量删除规格
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 查询单个实体类
     * @param id
     * @return
     */
    public TbSpecification findOne(Long id);

    /**
     * 添加规格
     * @param tbSpecification
     */
    public void add(TbSpecification tbSpecification);

    /**
     * 更新规格
     * @param tbSpecification
     */
    public void update(TbSpecification tbSpecification);
}
