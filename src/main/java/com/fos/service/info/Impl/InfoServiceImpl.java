package com.fos.service.info.Impl;

import com.fos.dao.info.TbInfoMapper;
import com.fos.entity.info.TbInfo;
import com.fos.enums.info.InfoEnums;
import com.fos.exception.CustomerException;
import com.fos.service.info.InfoService;
import com.fos.util.LoggerHelper;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/** @author FULO2 */
@Slf4j
@Service
public class InfoServiceImpl implements InfoService {

  @Resource private TbInfoMapper tbInfoMapper;

  @Override
  public List<TbInfo> findHeadLineInfoOnTheIndexPage() throws CustomerException {
    List<TbInfo> tbInfoMapperHeadLineInfoOnTheIndexPageList =
        tbInfoMapper.findHeadLineInfoOnTheIndexPage();
    if (!Objects.isNull(tbInfoMapperHeadLineInfoOnTheIndexPageList)
        && tbInfoMapperHeadLineInfoOnTheIndexPageList.size() > 0) {
      return tbInfoMapperHeadLineInfoOnTheIndexPageList;
    } else {
      LoggerHelper.createCustomeExcpetionLog(
          InfoServiceImpl.class.getSimpleName(),
          "findHeadLineInfoOnTheIndexPage",
          InfoEnums.HEADLINE_NOT_FOUND.getMsg());
      throw new CustomerException(
          InfoEnums.HEADLINE_NOT_FOUND.getCode(), InfoEnums.HEADLINE_NOT_FOUND.getMsg());
    }
  }

  @Override
  public List<TbInfo> findAllInfo() {
    List<TbInfo> tbInfos = tbInfoMapper.selectList(null);
    if(Objects.nonNull(tbInfos) && tbInfos.size()>0){
      return tbInfos;
    }else{
      LoggerHelper.createCustomeExcpetionLog(
              InfoServiceImpl.class.getSimpleName(),
              "findAllInfo",
              InfoEnums.INFO_NOT_EXISIT.getMsg()
      );
      throw new CustomerException(
              InfoEnums.INFO_NOT_EXISIT.getCode(),
              InfoEnums.INFO_NOT_EXISIT.getMsg()
      );
    }
  }

  @Override
  public TbInfo findInfoById(Integer infoId) {
    TbInfo tbInfo = tbInfoMapper.selectById(infoId);
    if(Objects.nonNull(tbInfo)){
      return tbInfo;
    }else{
      LoggerHelper.createCustomeExcpetionLog(
              InfoServiceImpl.class.getSimpleName(),
              "findInfoById",
              InfoEnums.HEADLINE_NOT_FOUND.getMsg()
      );
      throw new CustomerException(
              InfoEnums.HEADLINE_NOT_FOUND.getCode(),
              InfoEnums.HEADLINE_NOT_FOUND.getMsg()
      );
    }
  }
}
