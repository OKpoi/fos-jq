package com.fos.service.movietype;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

/**
 * @param <T1>
 * @param <T2>
 */
public abstract class BaseService<T1 extends Mapper, T2> {

  @Resource T1 t1;

  public T2 findById(Integer id) {
    T2 t2 = (T2) t1.selectByPrimaryKey(id);
    return t2;
  }

  public List<T2> findAll() {
    List selectAll = t1.selectAll();
    return selectAll;
  }

  @Transactional
  public Integer update(T2 t2) {
    int update = t1.updateByPrimaryKeySelective(t2);
    return update;
  }
}
