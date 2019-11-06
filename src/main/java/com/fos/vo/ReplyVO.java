package com.fos.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
    private Integer replyId;
    private Integer commentId;
    private String content;
    private String rcontent;
    private Date createTime;
    private Integer state;
    private Integer userId;
    private Integer parentId;
    private String userImg;
    private String userName;
}
