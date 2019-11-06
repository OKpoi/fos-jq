package com.fos.service.info;

import com.fos.entity.info.TbInfo;

import java.util.List;

public interface InfoService {
  List<TbInfo> findHeadLineInfoOnTheIndexPage();
  List<TbInfo> findAllInfo();
  TbInfo findInfoById(Integer infoId);
}
