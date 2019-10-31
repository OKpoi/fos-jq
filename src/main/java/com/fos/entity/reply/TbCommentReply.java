package com.fos.entity.reply;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_comment_reply")
public class TbCommentReply {
  /** 影评回复id */
  @TableId(type = IdType.AUTO)
  private Integer replyId;

  /** 评论ID */
  private Integer commentId;

  /** 内容 */
  private String rcontent;

  /** 时间 */
  private Date createTime;

  /** 删除与否(0-没删除,1-删除) */
  private Integer state;

  private Integer parentId;

  /** 回复用户id */
  private Integer userId;
}
