package com.fos.controller.movie;

import com.fos.entity.movie.TbMovie;
import com.fos.entity.movietype.TbMovieType;
import com.fos.enums.movie.MovieEnums;
import com.fos.service.movie.MovieService;
import com.fos.service.movietype.Impl.MovieTypeServiceImpl;
import com.fos.service.movietype.MovieTypeService;
import com.fos.util.RestHelper;
import com.fos.vo.MovieVO;
import com.fos.vo.RestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Resource
    MovieService movieService;
    @Resource
    MovieTypeService movieTypeService;
    @GetMapping("/allmovie")
    public RestVO findAllMovieList(){
        Set<TbMovie> tbMovies = movieService.findAllMovieList();
        return RestHelper.success(MovieEnums.QUERY_ALL_MOVIE_SUCCESS.getMsg(),tbMovies);
    }
    @GetMapping("/allmoviebytype")
    public RestVO findMovieByType(Integer typeId){
        Set<TbMovie> tbMovie = movieService.findMovieByTypeId(typeId);
        return RestHelper.success(MovieEnums.QUERY_MOVIE_BY_TYPE_SUCCESS.getMsg(),tbMovie);
    }
    @GetMapping("/movie")
    public  RestVO findMovieById(Integer movieId){
        TbMovie tbMovie = movieService.findMovieById(movieId);
        TbMovieType tbMovieType = movieTypeService.findMovieTypeById(tbMovie.getTypeId());
        MovieVO movieVO = MovieVO.builder().movieId(tbMovie.getMovieId())
                .movieImg(tbMovie.getMovieImg())
                .movieName(tbMovie.getMovieName())
                .movieTime(tbMovie.getMovieTime())
                .movieVideo(tbMovie.getMovieVideo())
                .actor(tbMovie.getActor())
                .country(tbMovie.getCountry())
                .director(tbMovie.getDirector())
                .language(tbMovie.getLanguage())
                .onTime(tbMovie.getOnTime())
                .typeName(tbMovieType.getTypeName())
                .profile(tbMovie.getProfile())
                .build();
        return RestHelper.success(MovieEnums.QUERY_MOVIE_SUCCESS.getMsg(),movieVO);
    }
}
