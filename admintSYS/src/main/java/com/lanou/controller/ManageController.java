package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lanou.bean.Power;
import com.lanou.bean.Role;
import com.lanou.bean.User;
import com.lanou.service.PowerService;
import com.lanou.service.RoleService;
import com.lanou.service.UserService;

import com.lanou.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manageController")
public class ManageController {

    @Autowired
    private UserService userService;
    @Autowired
    private PowerService powerService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/addManage")
    public ModelAndView addManage(User user){
        userService.addUser(user);
        Map map = new HashMap();
        map.put("msg",1);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/selectAllUser")
    public ModelAndView selectAllUser(){
        List<User> userList = userService.selectAllUser();
        for (User u:userList
             ) {
            int i = u.getCreateTime().length()-2;
            u.setCreateTime(u.getCreateTime().substring(0,i));
        }
        Map map = new HashMap();
        map.put("msg",userList);
        map.put("num",userList.size());
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/selectPowerById")
    @ResponseBody
    public String selectPowerById(HttpSession session){
        List<Power> powerList = null;
        if (session.getAttribute("id") != null) {
            powerList = powerService.selectPowerById((Integer) session.getAttribute("id"));
        }
        JSONArray json = JsonUtil.listToTree(JSON.parseArray(JSON.toJSONString(powerList)),"id","fId","children");
        return json.toJSONString();
    }

    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(Integer id){
        userService.deleteUserById(id);
        Map map = new HashMap();
        map.put("msg",1);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/deleteUsers")
    @ResponseBody
    public String deleteUsers(int[] userIds){
        for(int i=0;i<userIds.length;i++)
        {
            userService.deleteUserById(userIds[i]);
        }
        Map map = new HashMap();
        map.put("msg",1);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "redirect:/user/login.jsp";
    }

    @RequestMapping("/selectRoleName")
    public ModelAndView selectRoleName(HttpSession session){
        Role role = new Role();
        if (session.getAttribute("roleId") != null) {
            role = roleService.selectRoleById((Integer)session.getAttribute("roleId"));
        }
        Map map = new HashMap();
        map.put("msg",role.getRoleName());
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

}
