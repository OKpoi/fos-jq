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
  Integer typeId = 1101;

  @Test
  void should_return_list_size6_when_findAllMovieTypeList() {
    Set<TbMovieType> allMovieTypeList = movieTypeService.findAllMovieTypeList();
    Assert.assertEquals(6, allMovieTypeList.size());
  }
  @Test
  void should_return_tbmovietype_size1_when_findMovieTypeById(){
    TbMovieType tbMovieType = movieTypeService.findMovieTypeById(typeId);
    Assert.assertNotNull(tbMovieType);
  }
}
