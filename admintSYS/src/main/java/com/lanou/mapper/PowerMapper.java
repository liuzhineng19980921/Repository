package com.lanou.mapper;

import com.lanou.bean.Power;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerMapper {

    //根据id查询权限列表
    public List<Power> selectPowerById(@Param("id") Integer id);

    //查询所有权限列表
    public List<Power> selectAllPower();

    //查询顶级权限列表
    public List<Power> selectHeadPower();

    //保存权限
    public void addPower(Power power);

    //根据id查询单个权限
    public Power selectPower(Integer id);

    //修改权限
    public void updatePower(Power power);

    //删除权限节点
    public void deletePower(Integer id);

    //根据id查询子节点
    public List<Power> selectChildPower(Integer id);



}
