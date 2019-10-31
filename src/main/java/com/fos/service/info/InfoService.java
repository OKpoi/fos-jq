package com.fos.service.info;

import com.fos.entity.info.TbInfo;
import com.fos.service.BaseServiceInterface;
import java.util.List;

public interface InfoService extends BaseServiceInterface<TbInfo> {
  List<TbInfo> findHeadLineInfoOnTheIndexPage();
}
