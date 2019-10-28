package com.dao;

import com.entity.MovieType;

import java.util.List;

public interface MovieTypeDao {
    //查询所有的电影类型
    List <MovieType> queryAllMovieType();
}
