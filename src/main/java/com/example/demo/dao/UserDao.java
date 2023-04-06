package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User findById(Integer id);
    User findByEmail(String email);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username,String password);
    List<User> findAll();
    User create(User entity);
    User update(User entity);
    User delete(User entity);
    List<User> finAll(int pageNumber,int pageSize);
    List<User> findUsersLikedByVideoHref(Map<String, Object> params);
}
