package com.lanou.service.impl;

import com.lanou.bean.Power;
import com.lanou.mapper.PowerMapper;
import com.lanou.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerMapper powerMapper;

    @Override
    public List<Power> selectPowerById(Integer id) {
        return powerMapper.selectPowerById(id);
    }

    @Override
    public List<Power> selectAllPower() {
        return powerMapper.selectAllPower();
    }

    @Override
    public List<Power> selectHeadPower() {
        return powerMapper.selectHeadPower();
    }

    @Override
    public void addPower(Power power) {
        powerMapper.addPower(power);
    }

    @Override
    public Power selectPower(Integer id) {
        return powerMapper.selectPower(id);
    }

    @Override
    public void updatePower(Power power) {
        powerMapper.updatePower(power);
    }

    @Override
    public void deletePower(Integer id) {
        powerMapper.deletePower(id);
    }

    @Override
    public List<Power> selectChildPower(Integer id) {
        return powerMapper.selectChildPower(id);
    }


}

