package com.service;

import com.vo.VeiwMovie;
import com.vo.ViewRank;

import java.util.ArrayList;
import java.util.Date;

public interface MovieService {
    ArrayList<VeiwMovie> getAllMovie(int pageNum,int pageSize);

    VeiwMovie getMovieByMovieId(Integer movieId);

    VeiwMovie getMovieByMovieIdInfo(Integer movieId);

    ArrayList<VeiwMovie> getMovieByTypeId(Integer typeId);

    ArrayList<VeiwMovie> getMovieByTypeId(Integer typeId,int pageNum,int pageSize);

    ArrayList<VeiwMovie> getMovieByName(String movieName);

    int getMovieCount();

    ArrayList<VeiwMovie> getMovieFilter(String movieType, String country, String time, String language);
}
