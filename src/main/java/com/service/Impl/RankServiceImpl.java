package com.service.Impl;

import com.dao.RankDao;
import com.entity.Rank;
import com.service.RankService;
import com.vo.ViewRank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    RankDao rankDao;
    /*
    * 插入排行表中
    *
    * */
    @Override
    public int addRank(List<ViewRank> list) {
        //将list中的数据放入数据库
        for (int i = 0;i<list.size();i++){
           Rank rank = new Rank();
           ViewRank viewRank = list.get(i);
           //将VO转换为PO以放入数据库
           BeanUtils.copyProperties(viewRank,rank);
           rank.setDate(new Date());
           System.out.println(rank);
           rankDao.insertRank(rank);
        }
        return 1;
    }
    @Override
    public ArrayList<ViewRank> getAllMovieRank() {
        return rankDao.queryAllCommentAVG();
    }
}
