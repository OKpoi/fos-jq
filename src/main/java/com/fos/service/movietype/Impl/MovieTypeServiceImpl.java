package com.fos.service.movietype.Impl;

import com.fos.dao.movietype.TbMovieTypeMapper;
import com.fos.entity.movietype.TbMovieType;
import com.fos.enums.movietype.MovieTypeEnums;
import com.fos.exception.CustomerException;
import com.fos.service.movietype.MovieTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/** @author lomofu */
@Slf4j
@Service
public class MovieTypeServiceImpl implements MovieTypeService {

  @Resource private TbMovieTypeMapper movieTypeMapper;

  @Override
  public Set<TbMovieType> findAllMovieTypeList() throws CustomerException {

    List<TbMovieType> tbMovieTypeList = movieTypeMapper.selectList(null);
    if (!Objects.isNull(tbMovieTypeList) && tbMovieTypeList.size() > 0) {
      return new HashSet<>(tbMovieTypeList);
    } else {
      log.error("==================Exception====================");
      log.error(
          MovieTypeServiceImpl.class.getSimpleName()
              + "-> findAllMovieTypeList -> "
              + MovieTypeEnums.MOVIE_TYPE_IS_NOT_EXIT.getMsg());
      log.error("===============================================");
      throw new CustomerException(
          MovieTypeEnums.MOVIE_TYPE_IS_NOT_EXIT.getCode(),
          MovieTypeEnums.MOVIE_TYPE_IS_NOT_EXIT.getMsg());
    }
  }
}
