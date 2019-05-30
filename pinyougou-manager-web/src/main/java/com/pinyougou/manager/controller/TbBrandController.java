package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class TbBrandController {

    @Reference
    private BrandService brandService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    /**
     * 分页返回列表
     *
     * @param page 当前页码
     * @param rows 当前页数量
     * @return
     */
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows) {
        return brandService.findPage(page, rows);
    }

    /**
     * 添加品牌
     *
     * @param tbBrand
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody TbBrand tbBrand) {
        try {
            brandService.add(tbBrand);
            return new Result(true, "添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败！");
        }
    }

    /**
     * 修改品牌
     *
     * @param tbBrand
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败！");
        }
    }

    /**
     * 根据id获取实体类
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    /**
     * 根据数组ids删除品牌
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败！");
        }
    }

    /**
     * 查询+分页
     * @param tbBrand
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody TbBrand tbBrand, int page, int rows) {
        return brandService.findPage(tbBrand,page,rows);
    }
}
