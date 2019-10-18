package com.lanou.service;

import com.lanou.bean.Role;
import com.lanou.bean.User;

import java.util.List;

public interface RoleService {

    public List<Role> selectAllRole();

    public Role selectRoleById(Integer id);

    public List<Role> selectRoles();

    public void addRole(Role role);

    public Role selectRoleByName(String roleName);

    public Role selectRole(Integer id);

    public void updateRole(Role role);

    public List<User> selectUserByRid(Integer id);

    public void deleteRole(Integer id);

}
