package com.example.demo.service;

import com.example.demo.dto.VideoLikedInfo;

import java.util.List;

public interface StatsService {
    List<VideoLikedInfo> findVideoLikedInfo();
}
