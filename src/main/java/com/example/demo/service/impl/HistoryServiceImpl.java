package com.example.demo.service.impl;

import com.example.demo.dao.HistoryDao;
import com.example.demo.dao.impl.HistoryDaoImpl;
import com.example.demo.entity.History;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.service.HistoryService;
import com.example.demo.service.VideoService;

import java.sql.Timestamp;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    private HistoryDao dao;
    private VideoService videoService= new VideoServiceImpl();
    public HistoryServiceImpl(){
        dao=new HistoryDaoImpl();
    }
    @Override
    public List<History> findByUser(String username) {
        return dao.findByUser(username);
    }

    @Override
    public List<History> findByUserAndIsLiked(String username) {
        return dao.findByUserAndIsLiked(username);
    }

    @Override
    public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
        return dao.findByUserIdAndVideoId(userId,videoId);
    }

    @Override
    public History create(User user, Video video) {
        History existHistory=findByUserIdAndVideoId(user.getId(),video.getId());
        if(existHistory == null) {
            History History = new History();
            History.setUser(user);
            History.setVideo(video);
            History.setViewedDate(new Timestamp(System.currentTimeMillis()));
            History.setLiked(Boolean.FALSE);
            return dao.create(History);
        }
        return existHistory;
    }

    @Override
    public Boolean updateLikeOrUnlike(User user, String videoHref) {
        Video video=videoService.findByHref(videoHref);
        History existHistory=findByUserIdAndVideoId(user.getId(),video.getId());
        if(existHistory.getLiked()==Boolean.FALSE){
            existHistory.setLiked(Boolean.TRUE);
            existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
        }else {
            existHistory.setLiked(Boolean.FALSE);
            existHistory.setLikedDate(null);
        }
        History updatedHistory=dao.update(existHistory);
        return updatedHistory != null ? true : false;
    }
}
