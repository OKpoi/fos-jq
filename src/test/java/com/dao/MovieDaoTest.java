package com.dao;

import com.BaseTest;
import com.vo.VeiwMovie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MovieDaoTest extends BaseTest {
    @Autowired
    private MovieDao movieDao;


    @Test
    public void queryAllMovieTest(){
        List<VeiwMovie> list =new ArrayList<VeiwMovie>();
        list=movieDao.queryAllMovie();
       System.out.println(list.size());
        VeiwMovie veiwMovie=list.get(0);
       System.out.println(veiwMovie.getMovieId());
       System.out.println(veiwMovie.getMovieName());
    }

    @Test
    public void queryByMovieIdTest(){
      VeiwMovie veiwMovie=movieDao.queryByMovieId(2007);
        System.out.println(veiwMovie.getMovieId());
        System.out.println(veiwMovie.getMovieName());
    }

    @Test
    public void queryByMovieTypeTest(){
        List<VeiwMovie> list =new ArrayList<VeiwMovie>();
        list=movieDao.queryMovieByType(1104);

    }
    @Test
    public void queryByMovieNameTest(){
        ArrayList<VeiwMovie> veiwMovie=movieDao.queryByMoieName("小");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date datestart = null;
        Date dateend = null;
        try {
            datestart = simpleDateFormat.parse("2011");
            dateend = simpleDateFormat.parse("2012");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<VeiwMovie> veiwMovie_1 = movieDao.movieFilter("","",datestart,"",dateend);
        if(veiwMovie != null) {
            System.out.println("NOOOOOOOOOOOOOOOOOOOOO");
            return;
        }
        if(veiwMovie_1 != null) {
            System.out.println("NOOOOOOOOOOOOOOOOOOOOO");
            return;
        }
        System.out.println(veiwMovie.get(0).getMovieId());
        System.out.println(veiwMovie.get(0).getMovieName());
    }

}
