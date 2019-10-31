package com.fos.service;

import java.util.List;

public interface BaseServiceInterface<T> {

  T findById(Integer id);

  T findOne(T t);

  List<T> findAll();

  Boolean update(T t);

  Boolean insert(T t);
}
