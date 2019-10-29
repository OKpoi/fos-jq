package com.fos.service.movietype.Impl;

import com.fos.BaseTest;
import com.fos.service.movietype.MovieTypeService;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;

public class MovieTypeServiceImplTest extends BaseTest {

  @Resource private MovieTypeService movieTypeService;

  @Test
  public void findAllMovieTypeList() {
    movieTypeService.findAllMovieTypeList();
  }
}
