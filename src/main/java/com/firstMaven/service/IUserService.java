package com.firstMaven.service;

import com.firstMaven.pojo.User;

import java.util.List;

public interface IUserService {

    public User findUserById(int id);

    public int insertUser(User user);

    public int deleteUser(int id);

    public List<User> getUserByUserName(String userName,String password);







}
