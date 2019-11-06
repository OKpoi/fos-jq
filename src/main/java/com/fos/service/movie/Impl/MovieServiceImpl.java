package com.fos.service.movie.Impl;

import com.fos.dao.movie.TbMovieMapper;
import com.fos.dao.movietype.TbMovieTypeMapper;
import com.fos.entity.movie.TbMovie;
import com.fos.entity.movietype.TbMovieType;
import com.fos.enums.movie.MovieEnums;
import com.fos.exception.MovieException;
import com.fos.service.movie.MovieService;
import com.fos.util.LoggerHelper;
import com.fos.vo.MovieVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    TbMovieMapper tbMovieMapper;
    @Resource
    TbMovieTypeMapper tbMovieTypeMapper;
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
        Map<String,Object> filterMap = new HashMap<>();
        filterMap.put("type_id",typeId);
        List<TbMovie> tbMovies = tbMovieMapper.selectByMap(filterMap);
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
    public MovieVO findMovieById(Integer id) {
        TbMovie tbMovie = tbMovieMapper.selectById(id);
        TbMovieType tbMovieType =tbMovieTypeMapper.selectById(tbMovie.getTypeId());
        MovieVO movieVO = MovieVO.builder().build();
        BeanUtils.copyProperties(tbMovie,movieVO);
        BeanUtils.copyProperties(tbMovieType,movieVO);
        if(Objects.nonNull(movieVO)){
            return movieVO;
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
