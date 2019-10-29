package com.fos.entity.rank;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_rank")
public class TbRank {
  /** 排名标识符 */
  @Id
  @Column(name = "rank_id")
  private Integer rankId;

  /** 电影ID参考Comment表 */
  @Column(name = "movie_id")
  private Integer movieId;

  /** 平均分 */
  @Column(name = "avg_star")
  private Short avgStar;
}
