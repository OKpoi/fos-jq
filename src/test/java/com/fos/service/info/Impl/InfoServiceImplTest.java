package com.fos.service.info.Impl;

import com.fos.entity.info.TbInfo;
import com.fos.service.info.InfoService;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InfoServiceImplTest {

  @Resource private InfoService infoService;
  Integer infoId = 5001;
  @Test
  void should_return_list_size2_when_findHeadLineInfoOnTheIndexPage() {
    List<TbInfo> headLineInfoOnTheIndexPage = infoService.findHeadLineInfoOnTheIndexPage();
    Assert.assertEquals(2, headLineInfoOnTheIndexPage.size());
  }
  @Test
  void should_return_list_size2_when_findALLInfo(){
    List<TbInfo> tbInfos = infoService.findAllInfo();
    Assert.assertEquals(2,tbInfos.size());
  }
  @Test
  void should_return_TbInfo_size1_when_findInfoById(){
    TbInfo tbInfo = infoService.findInfoById(infoId);
    Assert.assertNotNull(tbInfo);
  }
}
