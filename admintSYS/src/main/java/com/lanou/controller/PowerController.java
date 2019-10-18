package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lanou.bean.Power;
import com.lanou.bean.Role;
import com.lanou.bean.RolePower;
import com.lanou.service.PowerService;
import com.lanou.service.RolePowerService;
import com.lanou.service.RoleService;
import com.lanou.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/powerController")
public class PowerController {

    @Autowired
    private PowerService powerService;
    @Autowired
    private RolePowerService rolePowerService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/selectAllPowers")
    public ModelAndView selectAllPowers(){
        List<Power> powerList = powerService.selectAllPower();
        Map map = new HashMap();
        map.put("msg",powerList);
        map.put("count",powerList.size());
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/selectHeadPowers")
    public ModelAndView selectHeadPowers(){
        List<Power> powerList = powerService.selectHeadPower();
        Map map = new HashMap();
        map.put("msg",powerList);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/savePower")
    public ModelAndView savePower(Power power){
        Map map = new HashMap();
        if (power.getId() == null || power.getId().equals("")){
            powerService.addPower(power);
            map.put("msg",1);
        }else {
            powerService.updatePower(power);
            map.put("msg",2);
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/selectOnePowerById")
    public ModelAndView selectOnePowerById(Integer id){
        Power power = powerService.selectPower(id);
        List<Power> powerList = powerService.selectHeadPower();
        Map map = new HashMap();
        map.put("msg",power);
        map.put("mag",powerList);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/deleteOnePower")
    public ModelAndView deleteOnePower(Integer id){
        Map map = new HashMap();
        List<Power> powerList = powerService.selectChildPower(id);
        if (powerList.size() == 0){
            powerService.deletePower(id);
            RolePower rolePower = rolePowerService.selectOneRolePower(id);
            if (rolePower != null){
                rolePowerService.deleteRolePower(id);
            }
            map.put("msg",1);
        }else {
            map.put("msg",2);
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/deletePowers")
    public ModelAndView deletePowers(int[] powerIds){
        Map map = new HashMap();
        List<Power> powerList = null;
        for(int i=0;i<powerIds.length;i++)
        {
            powerList = powerService.selectChildPower(powerIds[i]);
            if (powerList.size() > 0){
                map.put("msg",2);
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }
        }
        for(int i=0;i<powerIds.length;i++)
        {
            powerService.deletePower(powerIds[i]);
            RolePower rolePower = rolePowerService.selectOneRolePower(powerIds[i]);
            if (rolePower != null){
                rolePowerService.deleteRolePower(powerIds[i]);
            }
        }
        map.put("msg",1);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/powerList")
    public ModelAndView powerList(){
        List<Power> powerList = powerService.selectAllPower();
        JSONArray json = JsonUtil.listToTree(JSON.parseArray(JSON.toJSONString(powerList)),"id","fId","children");
        Map map = new HashMap();
        map.put("msg",json);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/powerList2")
    public ModelAndView powerList2(Integer id){
        List<Power> powerList = powerService.selectAllPower();
        JSONArray json = JsonUtil.listToTree(JSON.parseArray(JSON.toJSONString(powerList)),"id","fId","children");
        List<Integer> lists = rolePowerService.selectPowerId(id);
        ArrayList powerIds = new ArrayList();
        if (lists != null){
            for (Integer i:lists
                 ) {
                powerIds.add(i);
            }
        }
        Role role = roleService.selectRole(id);
        Map map = new HashMap();
        map.put("msg",json);
        map.put("pids",powerIds);
        map.put("role",role);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }


}
