package com.service;

import com.BaseTest;
import com.dao.MovieTypeDao;
import com.entity.MovieType;
import com.vo.VeiwMovie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieTypeServiceTest extends BaseTest {
    @Autowired
    private MovieTypeService movieTypeService;
    @Autowired
    private MovieService movieService;
    @Test
    public void getAllMovieTypeTest(){

        List<MovieType> movieTypeList=movieTypeService.getAllMovieType();
//        assertEquals("爱情",movieTypeList.get(1).getTypeName());
    }
    @Test
    public void getAllMovieTest(){
        System.out.println(movieService.getAllMovie(1,3));
    }
    @Test
    public void queryByMovieNameTest(){
        ArrayList<VeiwMovie> veiwMovie=movieService.getMovieByName("小黄大");
        if(veiwMovie != null) {
            System.out.println("NOOOOOOOOOOOOOOOOOOOOO");
            return;
        }
        System.out.println(veiwMovie.get(0).getMovieId());
        System.out.println(veiwMovie.get(0).getMovieName());
    }

}
