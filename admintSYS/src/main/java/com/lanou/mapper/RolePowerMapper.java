package com.lanou.mapper;

import com.lanou.bean.RolePower;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePowerMapper {

    //删除角色绑定权限
    public void deleteRolePower(Integer id);

    //根据权限id查询绑定角色
    public RolePower selectOneRolePower(Integer id);

    //绑定角色权限
    public void addRolePower(RolePower rolePower);

    //根据角色id查询绑定的权限id
    public List<Integer> selectPowerId(Integer id);

    //删除绑定权限
    public void deleteRolePower2(RolePower rolePower);


}
