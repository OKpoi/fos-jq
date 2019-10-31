package com.fos.service.movietype;

import com.fos.entity.movietype.TbMovieType;
import com.fos.service.BaseServiceInterface;
import java.util.Set;

public interface MovieTypeService extends BaseServiceInterface<TbMovieType> {
  Set<TbMovieType> findAllMovieTypeList();
}
