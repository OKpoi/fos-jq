package com.fos.service.movietype.Impl;

import com.fos.dao.movietype.TbMovieTypeMapper;
import com.fos.entity.movietype.TbMovieType;
import com.fos.enums.movietype.MovieTypeEnums;
import com.fos.exception.MovieTypeException;
import com.fos.service.AbstractBaseService;
import com.fos.service.movietype.MovieTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
public class MovieTypeServiceImpl extends AbstractBaseService<TbMovieType>
    implements MovieTypeService {

  @Resource private TbMovieTypeMapper movieTypeMapper;

  @Override
  public List<TbMovieType> findAll() {
    return movieTypeMapper.selectAll();
  }

  @Override
  public Set<TbMovieType> findAllMovieTypeList() throws MovieTypeException {

    List<TbMovieType> tbMovieTypeList = findAll();
    if (!Objects.isNull(tbMovieTypeList) && tbMovieTypeList.size() > 0) {
      return new HashSet<>(tbMovieTypeList);
    } else {
      log.error(
          "方法名称："
              + MovieTypeServiceImpl.class.getSimpleName()
              + " findAllMovieTypeList -> "
              + MovieTypeEnums.MOVIE_TYPE_IS_NOT_EXIT.getMsg());
      throw new MovieTypeException(MovieTypeEnums.MOVIE_TYPE_IS_NOT_EXIT);
    }
  }
}
