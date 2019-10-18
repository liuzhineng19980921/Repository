package com.lanou.service.impl;

import com.lanou.bean.User;
import com.lanou.mapper.UserMapper;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(String account, String password) {
        return userMapper.selectUser(account,password);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public void updateUserState1(Integer id) {
        userMapper.updateUserState1(id);
    }

    @Override
    public void updateUserState0(Integer id) {
        userMapper.updateUserState0(id);
    }

    @Override
    public void updateUserPwd(Integer id, String password) {
        userMapper.updateUserPwd(id,password);
    }


}


