package com.bysj.service.impl;

import com.bysj.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author 29029
 * @Version 1.0
 * @Time 17:16
 */
@Service
public class EmailServiceImpl implements EmailService {
    //默认编码
    public static final String DEFAULT_ENCODING = "UTF-8";

    //本身邮件的发送者，来自邮件配置
    @Value("${spring.mail.username}")
    private String userName;

    //邮件发送的对象，用于邮件发送
    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendMail(String title, String url, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发送人的邮箱
        message.setFrom(userName);
        //标题
        message.setSubject(title);
        //发给谁  对方邮箱
        message.setTo(email);
        //内容
        message.setText(url);
        //发送
        mailSender.send(message);
    }






}
