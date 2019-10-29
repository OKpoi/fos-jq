package com.fos.service.movietype;

import com.fos.entity.movietype.TbMovieType;
import java.util.Set;

public interface MovieTypeService {

  Set<TbMovieType> findAllMovieTypeList();
}
