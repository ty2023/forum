package com.bysj.controller;

import com.bysj.service.IForumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 29029
 * @Version 1.0
 * @Time 9:13
 */
@Controller
@RequestMapping("/forumsController")
public class ForumsController {

    @Autowired
    private IForumsService forumService;

}
