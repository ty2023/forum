package com.bysj.controller;

import com.bysj.entity.User;
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
 * @Time 12:49
 */
@Controller
@RequestMapping("userController")
public class UserController {

    @Autowired
    private IUserService userService;


    /**
     * 验证用户名唯一
     * @param userName
     * @return
     */
    @RequestMapping(value = "/getByUserName",produces="text/html;charset=utf8")
    @ResponseBody
    public String getByUserName(String userName){
        User user = userService.getByUserName(userName);
        if (user == null){
            return flag("true","用户名可用");
        }else {
            return flag("false","用户名已存在");
        }
    }

    /**
     * 注册
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/registerUser",produces = "text/html;charset=utf8")
    @ResponseBody
    public String registerUser(User user, HttpServletRequest request){
        Object object=request.getSession().getAttribute("emailCode");
        if (object == null || object ==""){
            return flag("false","该邮箱处于未验证状态，无法注册，请验证该邮箱");
        }
        Integer integer = userService.InsertUser(user);
        if (integer < 1){
            return flag("false","注册失败");
        }
        return flag("true","注册成功");
    }

    @RequestMapping(value = "/login",produces = "text/html;charset=utf8")
    @ResponseBody
    public String login(String userName,String passWord,HttpServletRequest request){
        User user = userService.login(userName,passWord);
        if (user == null){
            return flag("false","登录失败");
        }
        request.getSession().setAttribute("login_user",user);
        return flag("true","登录成功");
    }

    @RequestMapping(value = "/getUserPass",produces="text/html;charset=utf8")
    @ResponseBody
    public String getUserPass(String userName, ModelMap map, HttpServletRequest request){
        User user = userService.getByUserName(userName);
        if (user != null){
            map.put("userEmail",user.getEmail());
            map.put("userId",user.getId());
        }else {
            map.put("ff","该用户不存在");
        }
        return new Gson().toJson(map);
    }

    @RequestMapping(value = "/updateUserPassWord",produces="text/html;charset=utf8")
    @ResponseBody
    public String updateUserPassWord(Integer id,String passWord){
        Map<String, Object> map;
        map = new HashMap<String, Object>(10);
        int i = userService.updatePassword(passWord, id);
        if (i > 0){
            map.put("f","true");
            map.put("up","修改成功,即将返回登录页");
        }else {
            map.put("f","false");
            map.put("up","修改失败");
        }
        return new Gson().toJson(map);
    }


    public String flag(String flag,String msg){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("fl",flag);
        map.put("msg",msg);
        return new Gson().toJson(map);
    }

}
