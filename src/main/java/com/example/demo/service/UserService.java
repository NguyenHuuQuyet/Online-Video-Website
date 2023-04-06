package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    User findByEmail(String email);
    User findByUsername(String username);
    User login(String username,String password);
    User resetPassword(String email);
    List<User> findAll();
    List<User> finAll(int pageNumber,int pageSize);
    User register(String username,String password, String email);
    User update(User entity);
    User delete(String username);
    List<UserDto> findUsersLikedByVideoHref(String href);
}
