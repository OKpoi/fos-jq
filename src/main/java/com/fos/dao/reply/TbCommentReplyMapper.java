package com.fos.dao.reply;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fos.entity.reply.TbCommentReply;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TbCommentReplyMapper extends BaseMapper<TbCommentReply> {

    @Select("SELECT * FROM tb_comment_reply WHERE state = 0 AND comment_id = #{commentId}")
    List<TbCommentReply> selectActiveReplyByCommentId(@Param("commentId") Integer commentId);

    @Select("SELECT * FROM tb_comment_reply WHERE state = 0 AND user_id = #{userId}")
    List<TbCommentReply> selectActiveReplyByUserId(@Param("userId") Integer userId);

    @Select("SELECT * FROM tb_comment_reply WHERE state = 0 AND parent_id = #{parentId}")
    List<TbCommentReply> selectActiveReplyByParentId(@Param("parentId") Integer parentId);
}
