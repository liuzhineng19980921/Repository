package com.lanou.controller;

import com.lanou.bean.Role;
import com.lanou.bean.RolePower;
import com.lanou.bean.User;
import com.lanou.service.RolePowerService;
import com.lanou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.lang.reflect.Array;
import java.util.*;

@Controller
@RequestMapping("/roleController")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePowerService rolePowerService;

    @RequestMapping("/selectAllRoles")
    public ModelAndView selectAllRoles(){
        List<Role> roleList = roleService.selectAllRole();
        List<Role> roleList1 = roleService.selectRoles();
        List<Role> roleList2 = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Role r1:roleList
        ) {
            arrayList.add(r1.getId());
            roleList2.add(r1);
        }
        for (Role r2:roleList1
             ) {
            if (!arrayList.contains(r2.getId())){
                roleList2.add(r2);
            }
        }
        Map map = new HashMap();
        map.put("msg",roleList2);
        map.put("number",roleList2.size());
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/selectRole")
    public ModelAndView selectRole(){
        List<Role> roleList = roleService.selectRoles();
        Map map = new HashMap();
        map.put("msg",roleList);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }


    @RequestMapping("/addRole")
    public ModelAndView addRole(int[] powerIds,Role role){
        Map map = new HashMap();
        if (role.getId() == null){
        roleService.addRole(role);
        if (powerIds != null){
            Role role1 = roleService.selectRoleByName(role.getRoleName());
            int id = role1.getId();
            RolePower rolePower = new RolePower();
            rolePower.setRoleId(id);
            for(int i=0;i<powerIds.length;i++)
            {
                rolePower.setPowerId(powerIds[i]);
                rolePowerService.addRolePower(rolePower);
            }
            map.put("msg",1);
        }
        }else {
            roleService.updateRole(role);
            if (powerIds != null){
                List<Integer> lists = rolePowerService.selectPowerId(role.getId());
                RolePower rolePower2 = new RolePower();
                rolePower2.setRoleId(role.getId());
                if (lists != null){
                    for (Integer i:lists
                    ) {
                        rolePower2.setPowerId(i);
                        rolePowerService.deleteRolePower2(rolePower2);
                    }
                }
                RolePower rolePower = new RolePower();
                rolePower.setRoleId(role.getId());
                for(int i=0;i<powerIds.length;i++)
                {
                    rolePower.setPowerId(powerIds[i]);
                    rolePowerService.addRolePower(rolePower);
                }
            }
            map.put("msg",2);
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    @RequestMapping("/deleteRole")
    public ModelAndView deleteRole(Integer id){
        Map map = new HashMap();
        List<User> userList = roleService.selectUserByRid(id);
        if (userList.size() > 0){
            map.put("msg",1);
        }else {
            roleService.deleteRole(id);
            map.put("msg",2);
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

}
