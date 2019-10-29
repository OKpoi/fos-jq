package com.fos.service.movietype;

import com.fos.entity.movietype.TbMovieType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Set;

@SpringBootTest
public class MovieTypeServiceImplTest {

  @Resource private MovieTypeService movieTypeService;

  @Test
  public void findAllMovieTypeList() {
    Set<TbMovieType> allMovieTypeList = movieTypeService.findAllMovieTypeList();
    Assert.assertEquals(6, allMovieTypeList.size());
  }
}
