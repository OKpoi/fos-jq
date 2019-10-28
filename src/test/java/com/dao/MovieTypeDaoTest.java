package com.dao;

import com.BaseTest;
import com.entity.MovieType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieTypeDaoTest extends BaseTest {
    @Autowired
    private MovieTypeDao movieTypeDao;

    /**
     * 测试查询全部类型接口
     */
    @Test
    public void queryAllMovieType(){
        List<MovieType> movieTypeList=new ArrayList<>();
        movieTypeList=movieTypeDao.queryAllMovieType();
        assertEquals(5,movieTypeList.size());
    }


}
