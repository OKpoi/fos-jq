package com.fos.entity.movietype;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_movie_type")
public class TbMovieType {
  /** 类型ID */
  @Id
  @Column(name = "type_id")
  private Integer typeId;

  /** 类型名字 */
  @Column(name = "type_name")
  private String typeName;
}