package com.service.Impl;

import com.dao.MovieTypeDao;
import com.entity.MovieType;
import com.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public class MovieTypeServiceImpl implements MovieTypeService {
    @Autowired
    private MovieTypeDao movieTypeDao;

    @Override
    public List<MovieType> getAllMovieType() {
        return movieTypeDao.queryAllMovieType();
    }
}
