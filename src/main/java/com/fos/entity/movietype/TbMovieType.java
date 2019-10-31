package com.fos.entity.movietype;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_movie_type")
public class TbMovieType {
  /** 类型ID */
  @TableId(type = IdType.AUTO)
  private Integer typeId;

  /** 类型名字 */
  private String typeName;
}
