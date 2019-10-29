package com.fos.service.info.Impl;

import com.fos.dao.info.TbInfoMapper;
import com.fos.entity.info.TbInfo;
import com.fos.enums.info.InfoEnums;
import com.fos.exception.HeadLineException;
import com.fos.service.AbstractBaseService;
import com.fos.service.info.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class InfoServiceImpl extends AbstractBaseService<TbInfo> implements InfoService {

  @Resource private TbInfoMapper tbInfoMapper;

  @Override
  public List<TbInfo> findHeadLineInfoOnTheIndexPage() {

    List<TbInfo> tbInfoMapperHeadLineInfoOnTheIndexPageList =
        tbInfoMapper.findHeadLineInfoOnTheIndexPage();
    if (!Objects.isNull(tbInfoMapperHeadLineInfoOnTheIndexPageList)
        && tbInfoMapperHeadLineInfoOnTheIndexPageList.size() > 0) {
      return tbInfoMapperHeadLineInfoOnTheIndexPageList;
    } else {
      throw new HeadLineException(InfoEnums.HEADLINE_NOT_FOUND);
    }
  }
}
