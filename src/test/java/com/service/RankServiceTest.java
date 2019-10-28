package com.service;

import com.BaseTest;
import com.entity.Rank;
import com.util.JedisUtils;
import com.vo.ViewRank;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.ShardedJedis;

import java.util.ArrayList;
import java.util.List;

public class RankServiceTest extends BaseTest {
    private ShardedJedis shardedJedis;
    @Autowired
    RankService rankService;
    @Test
    public void testService(){
        ViewRank viewRank = new ViewRank();
        viewRank.setMovieId(2001);
        viewRank.setAvgStart(1);
        viewRank.setCount(10);
        viewRank.setMovieName("1");
        viewRank.setMovieImg("1");
       ArrayList<ViewRank> list = new ArrayList<ViewRank>();
        list.add(viewRank);
        list.add(viewRank);
        list.add(viewRank);
        ArrayList<ViewRank> list1 = new ArrayList<ViewRank>();
//        list1 = list.subList(0,1);
        String json = JSONObject.valueToString(list);
        JedisUtils.set("rank",json);
       /* String s = (String)JedisUtils.get("rank");
        list1 = (ArrayList<ViewRank>) JedisUtils.JsonToViewRank(s);*/
//        System.out.println(s);
//        System.out.println(rankService.addRank(list1));
        System.out.println(JedisUtils.get("rank"));
    }
}
