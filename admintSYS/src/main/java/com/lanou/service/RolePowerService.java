package com.lanou.service;

import com.lanou.bean.RolePower;

import java.util.List;

public interface RolePowerService {

    public void deleteRolePower(Integer id);

    public RolePower selectOneRolePower(Integer id);

    public void addRolePower(RolePower rolePower);

    public List<Integer> selectPowerId(Integer id);

    public void deleteRolePower2(RolePower rolePower);


}
