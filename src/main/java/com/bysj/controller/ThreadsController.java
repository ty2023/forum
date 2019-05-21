package com.bysj.controller;

import com.bysj.entity.Threads;
import com.bysj.entity.Topic;
import com.bysj.service.IThreadsService;
import com.bysj.service.ITopicService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 29029
 * @Version 1.0
 * @Time 12:11
 */
@Controller
@RequestMapping("threadsController")
public class ThreadsController {

    @Autowired
    private IThreadsService threadsService;

    @Autowired
    private ITopicService topicService;

    @RequestMapping("/getList")
    public String getList(Integer id, Model model){
        System.out.println(id);
        List<Threads> threadsList = threadsService.getList(id);
        Topic topic = topicService.getById(id);
        model.addAttribute("threads",threadsList);
        model.addAttribute("topic",topic);
        return "topicInfo";
    }

    @RequestMapping(value = "/InsertThreads",produces = "text/html;charset=utf8")
    @ResponseBody
    public String InsertThreads(Threads threads){
        Integer integer = threadsService.insertThreads(threads);
        if (integer >0){
            return flag("true","评论失败");
        }
        return flag("false","评论失败");
    }

    @RequestMapping(value = "/deleteThreads",produces = "text/html;charset=utf8")
    @ResponseBody
    public String deleteThreads(Integer id){
        Integer integer = threadsService.deleteThreads(id);
        if (integer >0){
            return flag("true","评论失败");
        }
        return flag("false","评论失败");
    }

    public String flag(String flag,String msg){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("fl",flag);
        map.put("msg",msg);
        return new Gson().toJson(map);
    }
}
