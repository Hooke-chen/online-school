package com.it.user.Util;

import redis.clients.jedis.Jedis;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 16622
 * \* Date: 2022/8/4
 * \* Time: 11:19
 * \* Description:
 * \
 */
public class Redis {
    private static String url = "192.168.124.131";
    private static int port = 6379;
    private static Jedis jedis=new Jedis(url,port);


    public static Jedis getRedis(){
        return jedis;
    }


    public static void closeRedis(){
        jedis.close();
    }
}