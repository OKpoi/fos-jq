package com.fos.service.movietype;

import com.fos.entity.movietype.TbMovieType;
import java.util.Set;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieTypeServiceImplTest {

  @Resource private MovieTypeService movieTypeService;

  @Test
  void should_return_list_size6_when_findAllMovieTypeList() {
    Set<TbMovieType> allMovieTypeList = movieTypeService.findAllMovieTypeList();
    Assert.assertEquals(6, allMovieTypeList.size());
  }
}
