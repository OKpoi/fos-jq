package com.dto;

import java.util.HashMap;
import java.util.List;

/**
 * 此类用于封装的json格式
 * 提供一个默认的构造方法和两个模板方法
 */

public class Layui extends HashMap<String, Object> {

    private Integer count;
    private String msg;
    private Integer num;
    private Object data;
    private String token;

    //单个查询操作成功的模板
    public static Layui select(Integer count, Object data,String msg) {
        Layui r = new Layui();
        r.put("code", 200);
        r.put("msg", msg);
        r.put("count", count);
        r.put("data", data);
        return r;
    }
    public static Layui select(Integer count, Object data,String msg,String token) {
        Layui r = new Layui();
        r.put("code", 200);
        r.put("msg", msg);
        r.put("token",token);
        r.put("count", count);
        r.put("data", data);
        return r;
    }

    //多个查询
    public static Layui selectAll(Integer count, Object data) {
        Layui r = new Layui();
        r.put("code", 200);
        r.put("msg", "查询结果集成功");
        r.put("count", count);
        r.put("data", data);
        return r;
    }

    //添加成功的模板
    public static Layui add(Integer count) {
        Layui r = new Layui();
        r.put("code", 200);
        r.put("msg", "注册成功");
        r.put("count", count);
        return r;
    }
    public static Layui success(String msg){
        Layui r=new Layui();
        r.put("code",200);
        r.put("msg",msg);
        r.put("count",1);
        return r;
    }
    //用于上传头像
    public static Layui success(String msg,String data){
        Layui r=new Layui();
        r.put("code",200);
        r.put("msg",msg);
        r.put("data",data);
        return r;
    }



    //自定义失败模板
    public static Layui fail(String msg){
        Layui r = new Layui();
        r.put("code", 400);
        r.put("msg", msg);
        r.put("count",0);
        return r;

    }


}
