package com.service;

import com.vo.ViewRank;

import java.util.ArrayList;
import java.util.List;

public interface RankService {
    //将排行插入表中
    int addRank(List<ViewRank> list);
    //获取排行
    ArrayList<ViewRank> getAllMovieRank();
}
