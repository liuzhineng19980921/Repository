package com.lanou.mapper;

import com.lanou.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //用户登录
    public User selectUser(@Param("account") String account, @Param("password") String password);

    //添加用户
    public void addUser(User user);

    //查询所有用户
    public List<User> selectAllUser();

    //删除单个用户
    public void deleteUserById(Integer id);

    //停用用户
    public void updateUserState1(Integer id);

    //恢复用户
    public void updateUserState0(Integer id);

    //修改密码
    public void updateUserPwd(@Param("id") Integer id, @Param("password") String password);


}
