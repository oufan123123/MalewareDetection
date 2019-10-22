package com.firstMaven.service.impl;

import com.firstMaven.pojo.User;
import com.firstMaven.dao.UserMapper;
import com.firstMaven.pojo.UserExample;
import com.firstMaven.service.IUserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;



@Service("userService")
public class UserServiceImpl implements IUserService{


    @Resource
    private UserMapper userMapper;



    @Override
    public User findUserById(int id){
         User user=userMapper.selectByPrimaryKey(id);
         System.out.println("here1");
         return user;
    }

    @Override
    public int insertUser(User user){
        int result=userMapper.insert(user);
        return result;
    }
    @Override
    public int deleteUser(int id){
        int result=userMapper.deleteByPrimaryKey(id);
        return result;
    }
    @Override
    public List<User> getUserByUserName(String userName,String password){
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        userExample.setDistinct(false);
        userExample.setOrderByClause("name asc");//升序
        if(StringUtils.isNotBlank(userName)){
            System.out.println("1");
            criteria.andNameEqualTo(userName);
        }
        if(StringUtils.isNotBlank(password)){
            System.out.println("2");
            criteria.andPasswordEqualTo(password);
        }
        List<User> userList=userMapper.selectByExample(userExample);
        if(userList!=null&&userList.size()>0){
            User user0=userList.get(0);
            System.out.println("查到了"+user0.getName());
            System.out.println("success");

        }
        return userList;


    }

}
