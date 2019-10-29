package com.fos.service.info.Impl;

import com.fos.entity.info.TbInfo;
import com.fos.service.info.InfoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class InfoServiceImplTest {

  @Resource private InfoService infoService;

  @Test
  void findHeadLineInfoOnTheIndexPage() {
    List<TbInfo> headLineInfoOnTheIndexPage = infoService.findHeadLineInfoOnTheIndexPage();
    Assert.assertEquals(2, headLineInfoOnTheIndexPage.size());
  }
}
