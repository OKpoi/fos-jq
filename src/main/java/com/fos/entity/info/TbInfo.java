package com.fos.entity.info;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_info")
public class TbInfo {
  /** 资讯id */
  @TableId(type = IdType.AUTO)
  private Integer infoId;

  /** 创建时间 */
  private Date createTime;

  /** 标题 */
  private String title;

  /** 内容 */
  private String infoContent;

  /** 管理员id */
  private Integer adminId;

  /** 图片 */
  private String infoImg;

  /** 资讯来源 */
  private String infoFrom;
}
