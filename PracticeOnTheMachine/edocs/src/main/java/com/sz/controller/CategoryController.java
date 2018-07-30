package com.sz.controller;

import com.github.pagehelper.PageInfo;
import com.sz.pojo.Category;
import com.sz.pojo.Entry;
import com.sz.service.CategoryService;
import com.sz.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private EntryService entryService;


    @RequestMapping("/page/{pageNum}/{categoryId}")
    public String page(Model model, @PathVariable("pageNum")Integer pageNum,
                       @PathVariable("categoryId") Long categoryId){
        System.out.println(categoryId +"分类的ID");
        model.addAttribute("categoryId",categoryId);
        // 查询所有的分类信息
        List<Category> categories =  categoryService.listAll();
        // 存储所有的分类信息
        model.addAttribute("categories",categories);

        // 查询所有的电子文档
        PageInfo<Entry> pageInfo = entryService.listWithPage(pageNum,categoryId);

        model.addAttribute("page",pageInfo);
        return "index";
    }

//    @RequestMapping("/{id}/page/{pageNum}")
//    public String categoryQuery(Model model, @PathVariable("pageNum")Integer pageNum){
//        // 查询所有的分类信息
//        List<Category> categories =  categoryService.listAll();
//        // 存储所有的分类信息
//        model.addAttribute("categories",categories);
//
//        // 查询所有的电子文档
//        PageInfo<Entry> pageInfo = entryService.listWithPage(pageNum);
//
//        model.addAttribute("page",pageInfo);
//        return "index";
//    }


}
