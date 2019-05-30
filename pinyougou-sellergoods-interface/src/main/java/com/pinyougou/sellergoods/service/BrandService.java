package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * 品牌服务层接口
 */
public interface BrandService {

    /**
     * 返回全部品牌列表
     *
     * @return
     */
    public List<TbBrand> findAll();

    /**
     * 返回分页列表
     *
     * @param pageNum  当前页码
     * @param pageSize 当前页数量
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 添加品牌
     *
     * @param tbBrand
     */
    public void add(TbBrand tbBrand);

    /**
     * 修改品牌
     *
     * @param tbBrand
     */
    public void update(TbBrand tbBrand);

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);

    /**
     * 根据数组ids批量删除品牌
     *
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 带条件分页
     *
     * @return
     */
    public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize);
}
