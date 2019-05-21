package com.bysj.controller;

import com.bysj.entity.Forums;
import com.bysj.entity.Topic;
import com.bysj.entity.User;
import com.bysj.service.IForumsService;
import com.bysj.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 29029
 * @Version 1.0
 * @Time 13:34
 */
@Controller
public class IndexController {

    @Autowired
    private IForumsService forumsService;

    @Autowired
    private ITopicService topicService;

    @RequestMapping("/forum")
    public String index(Forums forums,HttpServletRequest request, HttpSession session, Model model){
        List<Forums> list = forumsService.getList(forums.getType());
        List<Topic> topicServiceList = topicService.getList();
        User login_user =(User) request.getSession().getAttribute("login_user");
        session.setAttribute("user",login_user);
        model.addAttribute("forumsList",list);
        model.addAttribute("topicList",topicServiceList);
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
