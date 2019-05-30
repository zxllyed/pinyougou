package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SpcificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper tbSpecificationMapper;

    public PageResult findPage(TbSpecification tbSpecification, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbSpecificationExample TbSpecificationExample = new TbSpecificationExample();
        com.pinyougou.pojo.TbSpecificationExample.Criteria criteria = TbSpecificationExample.createCriteria();
        if (tbSpecification != null) {
            if (tbSpecification.getSpecName() != null && tbSpecification.getSpecName().length() > 0) {
                criteria.andSpecNameLike("%"+tbSpecification.getSpecName()+"%");
            }
        }
        Page<TbSpecification> page = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(TbSpecificationExample);
        return new PageResult(page.getTotal(), page.getResult());
    }

    public void delete(Long[] ids) {
        for (Long id : ids) {
            tbSpecificationMapper.deleteByPrimaryKey(id);
        }
    }

    public TbSpecification findOne(Long id) {
        return tbSpecificationMapper.selectByPrimaryKey(id);
    }

    public void add(TbSpecification tbSpecification) {
        tbSpecificationMapper.insert(tbSpecification);
    }

    public void update(TbSpecification tbSpecification) {
        tbSpecificationMapper.updateByPrimaryKey(tbSpecification);
    }
}
