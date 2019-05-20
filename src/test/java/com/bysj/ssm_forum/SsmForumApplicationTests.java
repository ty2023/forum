package com.bysj.ssm_forum;

import com.bysj.entity.User;
import com.bysj.service.EmailService;
import com.bysj.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmForumApplicationTests {
    @Autowired
    private EmailService emailService;

    @Autowired
    private IUserService userService;

    @Test
    public void contextLoads() {
        User user = userService.isExitEmail("2902992419@qq.com");
        if (user == null){
            System.out.println("这是空的");
        }else {
            System.out.println(user.toString());
        }
    }

}
