package com.fos.entity.reply;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tb_comment_reply")
public class TbCommentReply {
  /** 影评回复id */
  @Id
  @Column(name = "reply_id")
  private Integer replyId;

  /** 评论ID */
  @Column(name = "comment_id")
  private Integer commentId;

  /** 内容 */
  private String rcontent;

  /** 时间 */
  @Column(name = "create_time")
  private Date createTime;

  /** 删除与否(0-没删除,1-删除) */
  private Integer state;

  @Column(name = "parent_id")
  private Integer parentId;

  /** 回复用户id */
  @Column(name = "user_id")
  private Integer userId;
}
