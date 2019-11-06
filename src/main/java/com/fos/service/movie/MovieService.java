package com.fos.service.movie;

import com.fos.entity.movie.TbMovie;
import com.fos.vo.MovieVO;

import java.util.Set;

public interface MovieService {
    Set<TbMovie>  findAllMovieList();
    Set<TbMovie>  findMovieByTypeId(Integer typeId);
    MovieVO findMovieById(Integer id);
}
