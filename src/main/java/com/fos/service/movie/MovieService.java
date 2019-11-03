package com.fos.service.movie;

import com.fos.entity.movie.TbMovie;

import java.util.Set;

public interface MovieService {
    Set<TbMovie>  findAllMovieList();
    Set<TbMovie>  findMovieByTypeId(Integer typeId);
    TbMovie findMovieById(Integer id);
}
