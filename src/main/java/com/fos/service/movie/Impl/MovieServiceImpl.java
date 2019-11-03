package com.fos.service.movie.Impl;

import com.fos.dao.movie.TbMovieMapper;
import com.fos.entity.movie.TbMovie;
import com.fos.enums.movie.MovieEnums;
import com.fos.exception.MovieException;
import com.fos.service.movie.MovieService;
import com.fos.util.LoggerHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    TbMovieMapper tbMovieMapper;
    @Override
    public Set<TbMovie> findAllMovieList() {
        List<TbMovie> tbMovies = tbMovieMapper.selectList(null);
        if(Objects.nonNull(tbMovies) && tbMovies.size()>0){
            return new HashSet<>(tbMovies);
        }else {
            LoggerHelper.createCustomeExcpetionLog(
                    MovieServiceImpl.class.getSimpleName(),
                    "findAllMovieTypeList",
                    MovieEnums.MOVIE_IS_NOT_EXIT.getMsg());
            throw new MovieException(
                    MovieEnums.MOVIE_IS_NOT_EXIT.getCode(),
                    MovieEnums.MOVIE_IS_NOT_EXIT.getMsg());
        }
    }

    @Override
    public Set<TbMovie> findMovieByTypeId(Integer typeId) {
        Map<String,Object> map = new HashMap<>();
        map.put("type_id",typeId);
        List<TbMovie> tbMovies = tbMovieMapper.selectByMap(map);
        if(Objects.nonNull(tbMovies) && tbMovies.size()>0){
            return new HashSet<>(tbMovies);
        }else {
            LoggerHelper.createCustomeExcpetionLog(
                    MovieServiceImpl.class.getSimpleName(),
                    "findMovieByTypeId",
                    MovieEnums.QUERY_MOVIE_BY_TYPE_FAIL.getMsg());
            throw new MovieException(
                    MovieEnums.QUERY_MOVIE_BY_TYPE_FAIL.getCode(),
                    MovieEnums.QUERY_MOVIE_BY_TYPE_FAIL.getMsg());
        }
    }

    @Override
    public TbMovie findMovieById(Integer id) {
       TbMovie tbMovie = tbMovieMapper.selectById(id);
        if(Objects.nonNull(tbMovie)){
            return tbMovie;
        }else {
            LoggerHelper.createCustomeExcpetionLog(
                    MovieServiceImpl.class.getSimpleName(),
                    "findMovieById",
                    MovieEnums.QUERY_MOVIE_FAIL.getMsg());
            throw new MovieException(
                    MovieEnums.QUERY_MOVIE_FAIL.getCode(),
                    MovieEnums.QUERY_MOVIE_FAIL.getMsg());
        }
    }
}
