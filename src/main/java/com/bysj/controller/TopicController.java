package com.bysj.controller;

import com.bysj.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 29029
 * @Version 1.0
 * @Time 10:23
 */
@Controller
@RequestMapping("topicController")
public class TopicController {

    @Autowired
    private ITopicService topicService;
}
