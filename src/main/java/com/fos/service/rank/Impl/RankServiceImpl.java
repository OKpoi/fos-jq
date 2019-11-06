package com.fos.service.rank.Impl;


import com.fos.dao.movie.TbMovieMapper;
import com.fos.dao.rank.TbRankMapper;
import com.fos.dto.CommentToRankDTO;
import com.fos.entity.movie.TbMovie;
import com.fos.enums.rank.RankEnums;
import com.fos.exception.CustomerException;
import com.fos.service.rank.RankService;
import com.fos.util.LoggerHelper;
import com.fos.vo.RankVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class RankServiceImpl implements RankService {
    @Resource
    TbRankMapper tbRankMapper;
    @Resource
    TbMovieMapper tbMovieMapper;

    @Override
    public List<RankVO> findAllRank() {
        List<RankVO> rankVOS = tbRankMapper.getAllMovieRank();
        if (Objects.nonNull(rankVOS) && rankVOS.size() > 0) {
            return rankVOS;
        } else {
            LoggerHelper.createCustomeExcpetionLog(
                    RankServiceImpl.class.getSimpleName(),
                    "findAllRank",
                    RankEnums.QUERY_ALL_MOVIE_RANK_FAIL.getMsg()
            );
            throw new CustomerException(
                    RankEnums.QUERY_ALL_MOVIE_RANK_FAIL.getCode(),
                    RankEnums.QUERY_ALL_MOVIE_RANK_FAIL.getMsg()
            );
        }
    }

    @Override
    public List<TbMovie> findAllRankByCommentCount() {
        List<CommentToRankDTO> commentToRankDTOS = tbRankMapper.gerMovieIdByCommentCount();
        List<Integer> integers = new ArrayList<>();
        for (CommentToRankDTO commentToRankDTO : commentToRankDTOS) {
            integers.add(commentToRankDTO.getMovieId());
        }
        List<TbMovie> tbMovies = tbMovieMapper.selectBatchIds(integers);
        if (Objects.nonNull(tbMovies) && tbMovies.size() > 0) {
            return tbMovies;
        } else {
            LoggerHelper.createCustomeExcpetionLog(
                    RankServiceImpl.class.getSimpleName(),
                    "findAllRankByCommentCount",
                    RankEnums.QUERY_ALL_MOVIE_RANK_FAIL.getMsg()
            );
            throw new CustomerException(
                    RankEnums.QUERY_ALL_MOVIE_RANK_FAIL.getCode(),
                    RankEnums.QUERY_ALL_MOVIE_RANK_FAIL.getMsg()
            );
        }

    }
}
