package com.lanou.service;

import com.lanou.bean.Power;

import java.util.List;

public interface PowerService {

    public List<Power> selectPowerById(Integer id);

    public List<Power> selectAllPower();

    public List<Power> selectHeadPower();

    public void addPower(Power power);

    public Power selectPower(Integer id);

    public void updatePower(Power power);

    public void deletePower(Integer id);

    public List<Power> selectChildPower(Integer id);
}
