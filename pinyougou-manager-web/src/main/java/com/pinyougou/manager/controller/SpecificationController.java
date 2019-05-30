package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;

    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody TbSpecification tbSpecification) {
        try {
            specificationService.add(tbSpecification);
            return new Result(true, "添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败！");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody TbSpecification tbSpecification) {
        try {
            specificationService.update(tbSpecification);
            return new Result(true, "更新成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "更新失败！");
        }
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public TbSpecification findOne(Long id) {
        return specificationService.findOne(id);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(Long[] ids) {
        try {
            specificationService.delete(ids);
            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败！");
        }
    }

    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody TbSpecification tbSpecification, int page, int rows) {
        return specificationService.findPage(tbSpecification,page,rows);
    }
}
