package com.fos.service.movietype.Impl;

import com.fos.dao.movietype.TbMovieTypeMapper;
import com.fos.entity.movietype.TbMovieType;
import com.fos.service.movietype.BaseService;
import com.fos.service.movietype.MovieTypeService;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MovieTypeServiceImpl extends BaseService<TbMovieTypeMapper, TbMovieType>
    implements MovieTypeService {

  @Resource private TbMovieTypeMapper movieTypeDao;

  @Override
  public Set<TbMovieType> findAllMovieTypeList() {
    return (Set<TbMovieType>) super.findAll();
  }
}
