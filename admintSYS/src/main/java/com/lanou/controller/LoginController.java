package com.lanou.controller;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/loginController")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(String account, String password, HttpServletRequest request){
        User user = userService.selectUser(account,password);
        Map map = new HashMap();
        if (user != null){
            if (user.getState() == 0){
                map.put("msg",2);
                HttpSession session = request.getSession();
                session.setAttribute("username",user.getAccount());
                session.setAttribute("roleId",user.getRoleId());
                session.setAttribute("id",user.getId());
            }else {
                map.put("msg",1);
            }
        }else {
            map.put("msg",0);
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

}
