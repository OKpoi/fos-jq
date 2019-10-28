package com.dao;

import com.entity.MovieComment;
import com.entity.Rank;
import com.vo.ViewRank;

import java.util.ArrayList;

public interface RankDao {
    //插入排行表
    int insertRank(Rank rank);
    //查找排行
    ArrayList<ViewRank> queryAllCommentAVG();
}
