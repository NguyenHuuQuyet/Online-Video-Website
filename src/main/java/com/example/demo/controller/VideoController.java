package com.example.demo.controller;

import com.example.demo.constant.SessionAttr;
import com.example.demo.entity.History;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.service.HistoryService;
import com.example.demo.service.VideoService;
import com.example.demo.service.impl.HistoryServiceImpl;
import com.example.demo.service.impl.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/video")
public class VideoController extends HttpServlet {
    private static final long serialVersionUID = -2277125796700710444L;

    private VideoService videoService= new VideoServiceImpl();

    private HistoryService historyService = new HistoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionParam = req.getParameter("action");
        String href=req.getParameter("id");
        HttpSession session=req.getSession();
        switch (actionParam){
            case "watch":
                doGetWatch(session,href,req,resp);
                break;
            case "like":
                doGetLike(session,href,req,resp);
                break;
        }
    }
    //localhost:8080/asmjava4/video?action=watch&id={href}
    private void doGetWatch(HttpSession session,String href,HttpServletRequest req,
                            HttpServletResponse resp) throws ServletException, IOException{
        Video video=videoService.findByHref(href);
        req.setAttribute("video",video);
        User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
        if(currentUser != null){
            History history=historyService.create(currentUser,video);
            req.setAttribute("flagLikedBtn",history.getLiked());
        }
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/user/video-detail.jsp");
        requestDispatcher.forward(req,resp);
    }

    //localhost:8080/asmjava4/video?action=watch&id={href}
    private void doGetLike(HttpSession session,String href,HttpServletRequest req,
                            HttpServletResponse resp) throws ServletException, IOException{
       resp.setContentType("application/json");
        User currentUser=(User) session.getAttribute(SessionAttr.CURRENT_USER);
        boolean result =historyService.updateLikeOrUnlike(currentUser,href);
        if(result==true){
            resp.setStatus(204); //succeed but no data
        }else {
            resp.setStatus(400); //error
        }
    }
}
