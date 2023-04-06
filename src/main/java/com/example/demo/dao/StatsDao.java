package com.example.demo.dao;

import com.example.demo.dto.VideoLikedInfo;

import java.util.List;

public interface StatsDao {
    List<VideoLikedInfo> findVideoLikedInfo();
}
