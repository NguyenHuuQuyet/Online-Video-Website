package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.EmailService;
import com.example.demo.util.SendEmailUtil;

import javax.servlet.ServletContext;

public class EmailServiceImpl implements EmailService {
    private static final String EMAIL_WELCOME_SUBJECT="Welcome to Online Video";
    private static final String EMAIL_FORGOT_PASSWORD="Online Video - New Password";
    @Override
    public void sendMail(ServletContext context, User recipient, String type) {
       String host = context.getInitParameter("host");
       String port = context.getInitParameter("port");
       String user = context.getInitParameter("user");
       String pass = context.getInitParameter("pass");
       try{
            String content=null;
            String subject=null;
            switch (type){
                case "welcome":
                    subject = EMAIL_WELCOME_SUBJECT;
                    content ="Dear " + recipient.getUsername()+", hope you have a good time";
                    break;
                case "forgot":
                    subject=EMAIL_FORGOT_PASSWORD;
                    content="Dear " + recipient.getUsername()+", your new password here: "+recipient.getPassword();
                    break;
                default:
                    subject="Online video";
                    content="Maybe this email is wrong, don't care about it";
            }
           SendEmailUtil.sendEmail(host,port,user,pass,recipient.getEmail(),subject,content);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
