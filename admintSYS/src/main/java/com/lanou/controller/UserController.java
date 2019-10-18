package com.lanou.controller;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/manageController")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/updateStateUser1")
    public ModelAndView updateStateUser1(Integer id){
        userService.updateUserState1(id);
        Map map = new HashMap();
        map.put("msg",1);
        map.put("userId",id);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/updateStateUser0")
    public ModelAndView updateStateUser0(Integer id){
        userService.updateUserState0(id);
        Map map = new HashMap();
        map.put("msg",0);
        map.put("userId",id);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/updateUserPassword")
    public ModelAndView updateUserPassword(User user){
        userService.updateUserPwd(user.getId(),user.getPassword());
        Map map = new HashMap();
        map.put("msg",0);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

}
