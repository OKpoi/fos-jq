package com.fos.dao.user;

import com.fos.BaseTest;
import com.fos.entity.user.TbUser;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class TbUserMapperTest extends BaseTest {

  @Resource private TbUserMapper tbUserMapper;

  @Test
  public void findAll() {

    List<TbUser> tbUserList = tbUserMapper.selectAll();
    tbUserList.forEach(e -> System.out.println(e));
    Assert.assertEquals(1, tbUserList.size());
  }
}
