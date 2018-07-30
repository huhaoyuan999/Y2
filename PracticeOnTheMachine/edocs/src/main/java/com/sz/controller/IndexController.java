package com.sz.controller;

import com.github.pagehelper.PageInfo;
import com.sz.pojo.Category;
import com.sz.pojo.Entry;
import com.sz.service.CategoryService;
import com.sz.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private EntryService entryService;


    @RequestMapping("/")
    public String index(Model model){

        // 查询所有的分类信息
        List<Category> categories =  categoryService.listAll();
        // 存储所有的分类信息
        model.addAttribute("categories",categories);

        // 查询所有的电子文档
        PageInfo<Entry> pageInfo = entryService.listAll();

        model.addAttribute("page",pageInfo);
        return "index";
    }
}
