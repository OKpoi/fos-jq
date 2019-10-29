package com.fos.dao.movietype;

import com.fos.BaseTest;
import com.fos.entity.movietype.TbMovieType;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;

public class TbMovieTypeMapperTest extends BaseTest {

  @Resource private TbMovieTypeMapper movieTypeMapper;

  @Test
  public void findAll() {
    List<TbMovieType> tbMovieTypeList = movieTypeMapper.selectAll();
    Assert.assertEquals(6, tbMovieTypeList.size());
  }
}
