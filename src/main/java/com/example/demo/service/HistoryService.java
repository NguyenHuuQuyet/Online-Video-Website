package com.example.demo.service;

import com.example.demo.entity.History;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;

import java.util.List;

public interface HistoryService {
    List<History> findByUser(String username);
    List<History> findByUserAndIsLiked(String username);
    History findByUserIdAndVideoId(Integer userId,Integer videoId);
    History create(User user, Video video);
    Boolean updateLikeOrUnlike(User user,String videoHref);
}
