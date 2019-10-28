package com.service.Impl;

import com.dao.MovieDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.MovieService;
import com.vo.VeiwMovie;
import com.vo.ViewRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;
    /*
     *增加分页
     */
    @Override
    public ArrayList<VeiwMovie> getAllMovie(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList movieList= new ArrayList();
        movieList=movieDao.queryAllMovie();
        PageInfo page = new PageInfo(movieList);
        return movieList;
    }

    @Override
    public VeiwMovie getMovieByMovieId(Integer movieId) {
        return movieDao.queryByMovieId(movieId);
    }

    @Override
    public VeiwMovie getMovieByMovieIdInfo(Integer movieId) {
        return movieDao.queryByMovieIdInfo(movieId);
    }

    @Override
    public ArrayList<VeiwMovie> getMovieByTypeId(Integer typeId) {
        return movieDao.queryMovieByType(typeId);
    }

    @Override
    public ArrayList<VeiwMovie> getMovieByTypeId(Integer typeId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList movieTypeList= new ArrayList();
        movieTypeList=movieDao.queryMovieByType(typeId);
        PageInfo page = new PageInfo(movieTypeList);
        return movieTypeList;
    }

    /*
     *进行模糊查询的字符添加
     */
    @Override
    public ArrayList<VeiwMovie> getMovieByName(String movieName) {
        //将%添加进字符串中
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<movieName.length();i++){
            sb.append(movieName.charAt(i));
            if(i != movieName.length()-1)
                sb.append("%");
        }
        movieName = sb.toString();
        return movieDao.queryByMoieName(movieName);
    }
    /*
    *获取电影总数
    * */
    @Override
    public int getMovieCount() {
        ArrayList<VeiwMovie> list = movieDao.queryAllMovie();
        return list.size();
    }

    @Override
    public ArrayList<VeiwMovie> getMovieFilter(String movieType, String country, String time, String language) {
        //字符串类型转换为Date类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date datestart = null;
        Date dateend = null;
        if(time != null) {
            try {
                datestart = simpleDateFormat.parse(time);
                //把年份+1
                int tmptime = Integer.valueOf(time);
                tmptime++;
                dateend = simpleDateFormat.parse(Integer.toString(tmptime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return movieDao.movieFilter(movieType,country,datestart,language,dateend);
    }
}
