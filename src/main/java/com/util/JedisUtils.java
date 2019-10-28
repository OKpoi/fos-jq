package com.util;

import com.vo.ViewRank;
import org.json.JSONArray;
import org.json.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JedisUtils {

    private static Jedis jedis;
    //初始化
    private static void init() {
        JedisShardInfo shardInfo = new JedisShardInfo("redis://localhost:6379/9");
        shardInfo.setPassword("root");//这里是密码
        jedis = new Jedis(shardInfo);
        jedis.connect();
    }

    public static Boolean isexist(String key){
        JedisUtils.init();
       return jedis.exists(key);
    }


    //在redis中设置键值对存储
    public static void setToken(String userId, String token, int day) {
        int second = day * 60 * 60 * 24;
        JedisUtils.init();
        jedis.set(userId, token); //根据username存储token
        jedis.expire(userId, second);  //设置token持续时间
    }

    public static String getToken(String userId) {
        JedisUtils.init();
        String token = jedis.get(userId);  //获取token
        return token;
    }

    public static boolean deleteToken(String userId) {
        JedisUtils.init();
        long result = jedis.del(userId);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void set(String key ,Object object){
        int second = 7 * 60 * 60 * 24;
        JedisUtils.init();
        jedis.set(key.getBytes(),SerializeUtil.serizlize(object));
        jedis.expire(key,second);
    }
    public static Object get(String key){
        return SerializeUtil.deserialize(jedis.get(key.getBytes()));
    }
   /* //转换JSON为list
    public static List JsonToViewRank(String s){
        List<ViewRank> list = new ArrayList();
        JSONArray array = new JSONArray(s);
        JSONObject jsonOb = null;
        ViewRank rank = null;
        for (int i = 0; i < array.length(); i++) {
            rank = new  ViewRank();
            jsonOb = array.getJSONObject(i);
            rank.setCount(jsonOb.getInt("count"));
            rank.setMovieId(jsonOb.getInt("movieId"));
            rank.setAvgStart(jsonOb.getInt("avgStart"));
            list.add(rank);
        }
        return list;
    }*/
}
