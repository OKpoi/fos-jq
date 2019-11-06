package com.fos.controller.rank;

import com.fos.entity.movie.TbMovie;
import com.fos.enums.rank.RankEnums;
import com.fos.service.rank.RankService;
import com.fos.util.RestHelper;
import com.fos.vo.RankVO;
import com.fos.vo.RestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/rank")
public class RankController {
    @Resource
    RankService rankService;
    @RequestMapping
    public RestVO findAllRank(){
        List<RankVO> rankVOS = rankService.findAllRank();
        return RestHelper.success(RankEnums.QUERY_ALL_MOVIE_RANK_SUCCESS.getMsg(),rankVOS);
    }
    @RequestMapping("/comment")
    public RestVO findAllRankByCommentCount(){
        List<TbMovie> tbMovies = rankService.findAllRankByCommentCount();
        return RestHelper.success(RankEnums.QUERY_ALL_MOVIE_RANK_SUCCESS.getMsg(),tbMovies);
    }
}
