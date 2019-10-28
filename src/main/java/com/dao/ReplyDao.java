package com.dao;

import com.entity.MovieReply;
import com.vo.VeiwMovieReply;

import java.util.ArrayList;

public interface ReplyDao {

    ArrayList<VeiwMovieReply> queryRelyByUserId(Integer userId);

    int inserMovieReply(MovieReply movieReply);

    int delectMovieReply(MovieReply movieReply);
}
