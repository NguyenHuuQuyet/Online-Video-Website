package com.example.demo.service;

import com.example.demo.entity.User;

import javax.servlet.ServletContext;

public interface EmailService {
    void sendMail(ServletContext context, User recipient,String type);
}
