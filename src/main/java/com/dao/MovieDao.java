package com.dao;


import com.vo.VeiwMovie;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;

public interface MovieDao {

    ArrayList<VeiwMovie> queryAllMovie();

    ArrayList<VeiwMovie> queryMovieByType(Integer typeId);

    VeiwMovie queryByMovieId(Integer movieId);

    VeiwMovie queryByMovieIdInfo(Integer movieId);

    ArrayList<VeiwMovie> queryByMoieName(String movieName);

    ArrayList<VeiwMovie> movieFilter(@Param("movietype") String movieType, @Param("country") String country, @Param("timestart") Date timestart, @Param("language") String language,@Param("timeend") Date timeend);
}
