package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpcificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;
    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    public PageResult findPage(TbSpecification tbSpecification, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbSpecificationExample TbSpecificationExample = new TbSpecificationExample();
        com.pinyougou.pojo.TbSpecificationExample.Criteria criteria = TbSpecificationExample.createCriteria();
        if (tbSpecification != null) {
            if (tbSpecification.getSpecName() != null && tbSpecification.getSpecName().length() > 0) {
                criteria.andSpecNameLike("%" + tbSpecification.getSpecName() + "%");
            }
        }
        Page<TbSpecification> page = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(TbSpecificationExample);
        return new PageResult(page.getTotal(), page.getResult());
    }

    public void delete(Long[] ids) {
        for (Long id : ids) {
            tbSpecificationMapper.deleteByPrimaryKey(id);
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(id);
            tbSpecificationOptionMapper.deleteByExample(example);
        }
    }

    public Specification findOne(Long id) {
        //根据id查询出规格
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(id);
        //创建规格选项加强实体类
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        //创建条件对象
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        //规格选项的id等于刚刚查出的规格id
        criteria.andSpecIdEqualTo(id);
        //添加条件查询
        List<TbSpecificationOption> optionList = tbSpecificationOptionMapper.selectByExample(example);
        //创建组合实体类并且设置值
        Specification specification = new Specification();
        specification.setSpecification(tbSpecification);
        specification.setSpecificationOptionList(optionList);
        return specification;
    }

    public void add(Specification specification) {
        //插入规格
        tbSpecificationMapper.insert(specification.getSpecification());
        //插入规格项
        for (TbSpecificationOption tbSpecificationOption : specification.getSpecificationOptionList()) {
            tbSpecificationOption.setSpecId(specification.getSpecification().getId());
            tbSpecificationOptionMapper.insert(tbSpecificationOption);
        }
    }

    public void update(Specification specification) {
//        直接更新规格
        tbSpecificationMapper.updateByPrimaryKey(specification.getSpecification());
//        创建规格选项加强实体类
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
//        创建条件对象
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
//        添加条件
//        规格选项的id等于规格id
        criteria.andSpecIdEqualTo(specification.getSpecification().getId());
//        删除
        tbSpecificationOptionMapper.deleteByExample(example);
//        再一个一个插入
        for (TbSpecificationOption specificationOption : specification.getSpecificationOptionList()) {
            specificationOption.setSpecId(specification.getSpecification().getId());
            tbSpecificationOptionMapper.insert(specificationOption);
        }
    }

    public List<TbSpecification> findAll() {
        return tbSpecificationMapper.selectByExample(null);
    }
}
