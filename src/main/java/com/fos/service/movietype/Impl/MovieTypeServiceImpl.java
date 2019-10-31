package com.fos.service.movietype.Impl;

import com.fos.dao.movietype.TbMovieTypeMapper;
import com.fos.entity.movietype.TbMovieType;
import com.fos.enums.movietype.MovieTypeEnums;
import com.fos.exception.CustomerException;
import com.fos.service.movietype.MovieTypeService;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/** @author lomofu */
@Slf4j
@Service
public class MovieTypeServiceImpl implements MovieTypeService {

  @Resource private TbMovieTypeMapper movieTypeMapper;

  @Override
  public Set<TbMovieType> findAllMovieTypeList() throws CustomerException {

    List<TbMovieType> tbMovieTypeList = findAll();
    if (!Objects.isNull(tbMovieTypeList) && tbMovieTypeList.size() > 0) {
      return new HashSet<>(tbMovieTypeList);
    } else {
      log.error(
          "方法名称："
              + MovieTypeServiceImpl.class.getSimpleName()
              + " findAllMovieTypeList -> "
              + MovieTypeEnums.MOVIE_TYPE_IS_NOT_EXIT.getMsg());
      throw new CustomerException(
          MovieTypeEnums.MOVIE_TYPE_IS_NOT_EXIT.getCode(),
          MovieTypeEnums.MOVIE_TYPE_IS_NOT_EXIT.getMsg());
    }
  }

  @Override
  public TbMovieType findById(Integer id) {
    return null;
  }

  @Override
  public TbMovieType findOne(TbMovieType tbMovieType) {
    return null;
  }

  @Override
  public List<TbMovieType> findAll() {
    return movieTypeMapper.selectAll();
  }

  @Override
  public Boolean update(TbMovieType tbMovieType) {
    return null;
  }

  @Override
  public Boolean insert(TbMovieType tbMovieType) {
    return null;
  }
}
