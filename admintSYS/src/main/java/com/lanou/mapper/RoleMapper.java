package com.lanou.mapper;

import com.lanou.bean.Role;
import com.lanou.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    //查询所有角色和该角色绑定的用户
    public List<Role> selectAllRole();

    //根据id查角色名
    public Role selectRoleById(Integer id);

    //查询所有角色
    public List<Role> selectRoles();

    //添加角色
    public void addRole(Role role);

    //根据角色名查询角色id
    public Role selectRoleByName(@Param("roleName") String roleName);

    //根据id查询角色信息
    public Role selectRole(Integer id);

    //更新角色信息
    public void updateRole(Role role);

    //根据角色id查询绑定的用户
    public List<User> selectUserByRid(@Param("id") Integer id);

    //删除角色
    public void deleteRole(@Param("id") Integer id);

}
