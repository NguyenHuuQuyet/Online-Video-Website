package com.example.demo.service.impl;

import com.example.demo.dao.StatsDao;
import com.example.demo.dao.impl.StatsDaoImpl;
import com.example.demo.dto.VideoLikedInfo;
import com.example.demo.service.StatsService;

import java.util.List;

public class StatsServiceImpl implements StatsService {
    private StatsDao statsDao;

    public StatsServiceImpl(){
        statsDao = new StatsDaoImpl();
    }

    @Override
    public List<VideoLikedInfo> findVideoLikedInfo() {
        return statsDao.findVideoLikedInfo();
    }
}
