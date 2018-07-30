package com.sz.controller;

import com.sz.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/entry")
public class EntryController {


    @Autowired
    private EntryService entryService;


    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Map<String,Object> delete(@PathVariable("id") Integer id){

        Map<String,Object> map = new HashMap<>();
        String msg = "fail";

        int row = entryService.delete(id);
        if(row == 1)
            msg = "suc";
        map.put("msg",msg);


        return map;
    }

}
