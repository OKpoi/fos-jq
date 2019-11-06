package com.fos.service.movie;


import com.fos.entity.movie.TbMovie;
import com.fos.vo.MovieVO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Set;

@SpringBootTest
public class MovieServiceImplTest {
    @Resource
    MovieService movieService;
    Integer typeId = 1101;
    Integer movieId = 2001;
    @Test
    void should_return_list_size7_when_findAllMovieList(){
        Set<TbMovie> tbMovies = movieService.findAllMovieList();
        Assert.assertEquals(7, tbMovies.size());
    }
    @Test
    void should_return_list_size2_when_findMovieByTypeId(){
        Set<TbMovie> tbMovies = movieService.findMovieByTypeId(typeId);
        Assert.assertEquals(2,tbMovies.size());
    }
    @Test
    void  should_return_movieVO_size1_when_findMovieById(){
        MovieVO movieVO = movieService.findMovieById(movieId);
        System.out.println(movieVO.toString());
        Assert.assertNotNull(movieVO);
    }
}
