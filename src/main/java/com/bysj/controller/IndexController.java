package com.bysj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 29029
 * @Version 1.0
 * @Time 13:34
 */
@Controller
public class IndexController {

    @RequestMapping("/forum")
    public String index(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }

    @RequestMapping("/updatePass/{id}")
    public String updatePass(@PathVariable Integer id){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        return "updatepass";
    }
}
