package com.fos.entity.info;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_info")
public class TbInfo {
  /** 资讯id */
  @Id
  @Column(name = "info_id")
  private Integer infoId;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;

  /** 标题 */
  private String title;

  /** 内容 */
  @Column(name = "info_content")
  private String infoContent;

  /** 管理员id */
  @Column(name = "admin_id")
  private Integer adminId;

  /** 图片 */
  @Column(name = "info_img")
  private String infoImg;

  /** 资讯来源 */
  @Column(name = "info_from")
  private String infoFrom;
}
