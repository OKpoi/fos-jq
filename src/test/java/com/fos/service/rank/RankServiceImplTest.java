package com.fos.service.rank;

import com.fos.entity.movie.TbMovie;
import com.fos.vo.RankVO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class RankServiceImplTest {
    @Resource
    RankService rankService;
    @Test
    void should_return_list_size3_when_findAllRank(){
        List<RankVO> rankVOS =  rankService.findAllRank();
        Assert.assertEquals(3,rankVOS.size());
    }
    @Test
    void should_return_list_size7_when_findAllRankByCommentCount(){
        List<TbMovie> tbMovies = rankService.findAllRankByCommentCount();
        Assert.assertEquals(7,tbMovies.size());
    }
}
