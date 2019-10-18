package com.lanou.service.impl;

import com.lanou.bean.RolePower;
import com.lanou.mapper.RolePowerMapper;
import com.lanou.service.RolePowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePowerServiceImpl implements RolePowerService {

    @Autowired
    private RolePowerMapper rolePowerMapper;

    @Override
    public void deleteRolePower(Integer id) {
        rolePowerMapper.deleteRolePower(id);
    }

    @Override
    public RolePower selectOneRolePower(Integer id) {
        return rolePowerMapper.selectOneRolePower(id);
    }

    @Override
    public void addRolePower(RolePower rolePower) {
        rolePowerMapper.addRolePower(rolePower);
    }

    @Override
    public List<Integer> selectPowerId(Integer id) {
        return rolePowerMapper.selectPowerId(id);
    }

    @Override
    public void deleteRolePower2(RolePower rolePower) {
        rolePowerMapper.deleteRolePower2(rolePower);
    }

}
