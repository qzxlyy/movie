package com.fh.utils;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.List;

/*import com.fh.entity.po.Area;*/

public class RedisUse {
    public static void set(String key,String value){
        Jedis jedis = RedisUtlis.getJedis();
        jedis.set(key,value);
        RedisUtlis.returnJedis(jedis);
    }

    public static void set(String key,String value,int seconds){
        Jedis jedis = RedisUtlis.getJedis();
        jedis.setex(key,seconds,value);
        RedisUtlis.returnJedis(jedis);
    }

    public static String get(String key){
        Jedis jedis = RedisUtlis.getJedis();
        String value=jedis.get(key);
        RedisUtlis.returnJedis(jedis);
        return value;
    }
    public static void hset(String key,String filed,String value){
        Jedis jedis = RedisUtlis.getJedis();
        Long hset = jedis.hset(key, filed, value);
        RedisUtlis.returnJedis(jedis);
    }

    public static long hlen(String key){
        Jedis jedis = RedisUtlis.getJedis();
        Long hlen = jedis.hlen(key);
        RedisUtlis.returnJedis(jedis);
        return hlen;
    }
    public static  String  hget(String key,String filed){
        Jedis jedis = RedisUtlis.getJedis();
        String hget = jedis.hget(key, filed);
        RedisUtlis.returnJedis(jedis);
        return hget;
    }
    public static List<String> hvals(String key){
        Jedis jedis = RedisUtlis.getJedis();
        List<String> hvals = jedis.hvals(key);
        RedisUtlis.returnJedis(jedis);
        return hvals;
    }
  /* public  static  String getAreaName(String area){
        Jedis jedis = RedisUtlis.getJedis();
        StringBuffer sb=new StringBuffer();//存放中文名
        String[] split = area.split(",");
        for (int i = 0; i <split.length ; i++) {
            String  areaId =  split[i];
            String area_qzx = jedis.hget("area_qzx", areaId);
            Area area1 = JSONObject.parseObject(area_qzx, Area.class);
            sb.append(area1.getName()).append(",");
        }
        RedisUtlis.returnJedis(jedis);
        return  sb.toString();
    }*/
    public static void hdel(String key,String filed){
        Jedis jedis = RedisUtlis.getJedis();
        jedis.hdel(key,filed);
        RedisUtlis.returnJedis(jedis);
    }
    public  static  boolean  exists(String key){
        Jedis jedis = RedisUtlis.getJedis();
        Boolean exists = jedis.exists(key);
        RedisUtlis.returnJedis(jedis);
        return exists;
    }


}
