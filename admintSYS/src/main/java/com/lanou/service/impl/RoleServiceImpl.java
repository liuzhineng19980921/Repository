package com.lanou.service.impl;

import com.lanou.bean.Role;
import com.lanou.bean.User;
import com.lanou.mapper.RoleMapper;
import com.lanou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }

    @Override
    public Role selectRoleById(Integer id) {
        return roleMapper.selectRoleById(id);
    }

    @Override
    public List<Role> selectRoles() {
        return roleMapper.selectRoles();
    }

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public Role selectRoleByName(String roleName) {
        return roleMapper.selectRoleByName(roleName);
    }

    @Override
    public Role selectRole(Integer id) {
        return roleMapper.selectRole(id);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public List<User> selectUserByRid(Integer id) {
        return roleMapper.selectUserByRid(id);
    }

    @Override
    public void deleteRole(Integer id) {
        roleMapper.deleteRole(id);
    }
}
