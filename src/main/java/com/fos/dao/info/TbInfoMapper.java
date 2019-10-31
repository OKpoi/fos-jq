package com.fos.dao.info;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fos.entity.info.TbInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbInfoMapper extends BaseMapper<TbInfo> {

  @Select("SELECT * FROM tb_info ORDER BY create_time DESC LIMIT 4")
  List<TbInfo> findHeadLineInfoOnTheIndexPage();
}
