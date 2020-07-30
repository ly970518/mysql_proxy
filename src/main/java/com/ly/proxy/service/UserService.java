package com.ly.proxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.proxy.domain.User;
import com.ly.proxy.dynamicdatasource.DataSourceSelector;
import com.ly.proxy.dynamicdatasource.DynamicDataSourceEnum;
import com.ly.proxy.mapper.UserMapper;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public List<User> listUser() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @DataSourceSelector(value = DynamicDataSourceEnum.MASTER)
    public int update() {
        User user = new User();
        user.setUserId(Long.parseLong("22"));
        user.setUserName("修改后的名字2");
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @DataSourceSelector(value = DynamicDataSourceEnum.SLAVE)
    public User find() {
        User user = new User();
        user.setUserId(Long.parseLong("1196978513958141952"));
        return userMapper.selectByPrimaryKey(user);
    }
}
