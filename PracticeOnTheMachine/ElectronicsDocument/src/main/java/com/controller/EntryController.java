package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.Category;
import com.pojo.Entry;
import com.service.CategoryService;
import com.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 电子文档控制类
 */
@Controller
@RequestMapping("/category")
public class EntryController {
    //声明电子文档分类表业务逻辑层接口
    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    //声明电子文档条目表业务逻辑层接口
    @Autowired
    @Qualifier("entryService")
    private EntryService entryService;

    /**
     * 初始化信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/init/{pageNo}/{pageSize}/{categoryId}")
    public String CategoryEntry(@PathVariable("pageNo") Integer pageNo,
                                @PathVariable("pageSize") Integer pageSize,
                                @PathVariable("categoryId") Integer categoryId,
                                Model model) {
        List<Category> list = categoryService.queryAllInfo();
        PageInfo<Entry> pageInfo = entryService.queryEntryInfo(categoryId, null, pageNo, pageSize);
        model.addAttribute("category", list);
        model.addAttribute("page", pageInfo);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("indexCategory", "OK");
        return "index2";
    }

    /**
     * 按（类别/名称）查询
     *
     * @param model
     * @return
     */
    @RequestMapping("/categoryIdName")
    public String CategoryEntryCategoryId(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                                          @RequestParam(value = "title", required = false) String title, Model model) {
        List<Category> list = categoryService.queryAllInfo();
        PageInfo<Entry> pageInfo = entryService.queryEntryInfo(categoryId, title, 1, 5);
        model.addAttribute("category", list);
        model.addAttribute("page", pageInfo);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("indexCategory", "OK");
        return "index2";
    }


    /**
     * 增加电子文档条目信息
     *
     * @param entry
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public String addEntryInfo(@RequestBody Entry entry) {
        int num = entryService.addEntryInfo(entry);
        String fulag = "false";
        if (num > 0) {
            fulag = "true";
        } else {
            fulag = "false";
        }
        return fulag;
    }

    /**
     * 修改电子文档条目信息
     *
     * @param entry
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateEntryInfo(@RequestBody Entry entry) {
        int num = entryService.updateInfo(entry);
        String fulag = "false";
        if (num > 0) {
            fulag = "true";
        } else {
            fulag = "false";
        }
        return fulag;
    }

    /**
     * 根据id删除指定信息
     *
     * @param
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteEntryInfo(@RequestBody Entry entry) {
        int num = entryService.deleteEntryInfo(entry.getId());
        String fulag = "false";
        if (num > 0) {
            fulag = "true";
        } else {
            fulag = "false";
        }
        return fulag;
    }

    /**
     * 根据ID查询指定信息
     *
     * @return
     */
    @RequestMapping("/query/{id}")
    public String queryInfoId(@PathVariable("id") Integer id, Model model) {
        Entry entry = entryService.queryIdInfo(id);
        model.addAttribute("entry", entry);
        return "add";
    }

}
