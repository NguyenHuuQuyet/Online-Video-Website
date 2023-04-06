package com.example.demo.dao;

import com.example.demo.entity.History;

import java.util.List;

public interface HistoryDao {
    List<History> findByUser(String username);
    List<History> findByUserAndIsLiked(String username);
    History findByUserIdAndVideoId(Integer userId,Integer videoId);
    History create(History entity);
    History update(History entity);
}
