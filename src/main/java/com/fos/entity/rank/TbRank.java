package com.fos.entity.rank;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_rank")
public class TbRank {
  /** 排名标识符 */
  @TableId(type = IdType.AUTO)
  private Integer rankId;

  /** 电影ID参考Comment表 */
  private Integer movieId;

  /** 平均分 */
  private Short avgStar;
}
