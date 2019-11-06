package com.fos.service.rank;


import com.fos.entity.movie.TbMovie;
import com.fos.vo.RankVO;

import java.util.List;


public interface RankService {
    List<RankVO> findAllRank();
    List<TbMovie> findAllRankByCommentCount();
}
