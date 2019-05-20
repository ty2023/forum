package com.bysj.controller;

import com.bysj.entity.User;
import com.bysj.service.EmailService;
import com.bysj.service.IUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 29029
 * @Version 1.0
 * @Time 17:31
 */
@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private IUserService userService;

    /**
     * 发送验证码给邮箱
     * @param email
     * @return
     */
    @RequestMapping(value = "/sendForgetPasswordAuthCodeEmail",produces="text/html;charset=utf8")
    @ResponseBody
    public String sendForgetPasswordAuthCodeEmail(String email, HttpServletRequest request){
        if (email == "" || email == null){
            return flag("false","发送失败,请检查邮箱");
        }
        User user = userService.isExitEmail(email);
        if (user != null){
            return flag("false","邮箱已存在请重新输入");
        }
        String Code = "您的验证码是----》"+code().toString();
        System.out.println(Code);
        request.getSession().setAttribute("emailCode",Code);
        String title = "注册新用户";
        emailService.sendMail(title,Code,email);
        return flag("true","发送成功");
    }

    @RequestMapping(value = "/UpdateUserPass",produces="text/html;charset=utf8")
    @ResponseBody
    public String updateUserPassWord(String email,Integer id, HttpServletRequest request){
        System.out.println(id);
        //获取http
        String scheme = request.getScheme();
        //获取http://localhost
        String serverName = request.getServerName();
        //获取端口
        int serverPort = request.getServerPort();
        //写入地址
        String contextPath = "/updatePass/"+id;
        String url = scheme+"://"+serverName+":"+serverPort+contextPath;
        String path = "请点此处修改密码,<a href="+url+">修改密码</a>";
        String title = "修改密码";
        emailService.sendMail(title,path,email);
        return flag("true","发送成功");
    }

    @RequestMapping(value = "/checkeForgetPasswordVcode",produces="text/html;charset=utf8")
    @ResponseBody
    public String checkeForgetPasswordVcode(String checkCode, HttpServletRequest request, ModelMap map){
        if (checkCode == "" || checkCode == null) {
            return flag("false","验证码为空");
        }else {
            String Code= (String)request.getSession().getAttribute("emailCode");
            if (!checkCode.equalsIgnoreCase(Code)){
                return flag("false","验证失败");
            }else {
                return flag("true","验证成功");
            }
        }
    }


    /**
     * 生成随机数字
     * @return
     */
    public Integer code(){
        return (int)(Math.random()*(9999-1000+1)+1000);
    }

    public String flag(String flag,String msg){
        Map<String,Object> map = new HashMap<String, Object>();
            map.put("fl",flag);
            map.put("msg",msg);
        return new Gson().toJson(map);
    }
}
