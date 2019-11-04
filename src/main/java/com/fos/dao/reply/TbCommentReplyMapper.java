package com.fos.dao.reply;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fos.entity.reply.TbCommentReply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbCommentReplyMapper extends BaseMapper<TbCommentReply> {

    @Select("SELECT * FROM tb_comment_reply WHERE state = 0 AND comment_id = #{commentId}")
    List<TbCommentReply> selectActiveReplyByCommentId(@Param("commentId") Integer commentId);

}
