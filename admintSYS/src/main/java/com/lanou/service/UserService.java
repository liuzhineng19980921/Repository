package com.lanou.service;

import com.lanou.bean.User;

import java.util.List;

public interface UserService {

    //登录查询
    public User selectUser(String account, String password);

    public void addUser(User user);

    public List<User> selectAllUser();

    public void deleteUserById(Integer id);

    public void updateUserState1(Integer id);

    public void updateUserState0(Integer id);

    public void updateUserPwd(Integer id, String password);

}
