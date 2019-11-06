package com.fos.dao.rank;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fos.dto.CommentToRankDTO;
import com.fos.entity.movie.TbMovie;
import com.fos.entity.rank.TbRank;
import com.fos.vo.RankVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbRankMapper extends BaseMapper<TbRank> {
    @Select("SELECT m.movie_id,m.movie_name,m.movie_img,r.avg_star FROM `tb_rank` r,tb_movie m where r.movie_id = m.movie_id ORDER BY avg_star DESC")
    List<RankVO> getAllMovieRank();
    @Select("SELECT movie_id, COUNT(*) comment_count FROM `tb_movie_comment` GROUP BY movie_id ORDER BY comment_count DESC")
    List<CommentToRankDTO> gerMovieIdByCommentCount();
}
