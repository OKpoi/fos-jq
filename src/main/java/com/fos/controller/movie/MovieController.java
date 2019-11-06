package com.fos.controller.movie;

import com.fos.entity.movie.TbMovie;
import com.fos.enums.movie.MovieEnums;
import com.fos.service.movie.MovieService;
import com.fos.service.movietype.MovieTypeService;
import com.fos.util.RestHelper;
import com.fos.vo.MovieVO;
import com.fos.vo.RestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Resource
    MovieService movieService;


    @GetMapping("/allmovie")
    public RestVO findAllMovieList() {
        Set<TbMovie> tbMovies = movieService.findAllMovieList();
        return RestHelper.success(MovieEnums.QUERY_ALL_MOVIE_SUCCESS.getMsg(), tbMovies);
    }

    @GetMapping("/allmoviebytype")
    public RestVO findMovieByType(@RequestParam("typeId") Integer typeId) {
        Set<TbMovie> tbMovie = movieService.findMovieByTypeId(typeId);
        return RestHelper.success(MovieEnums.QUERY_MOVIE_BY_TYPE_SUCCESS.getMsg(), tbMovie);
    }

    @GetMapping("/movie")
    public RestVO findMovieById(@RequestParam("movieId") Integer movieId) {
        MovieVO movieVO = movieService.findMovieById(movieId);
        return RestHelper.success(MovieEnums.QUERY_MOVIE_SUCCESS.getMsg(), movieVO);
    }
}
