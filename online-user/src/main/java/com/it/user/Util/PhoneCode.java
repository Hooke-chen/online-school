package com.it.user.Util;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 16622
 * \* Date: 2022/8/4
 * \* Time: 16:46
 * \* Description:手机验证码
 * \
 */
public class PhoneCode {
    //生成验证码
    public String getCode(){
        Random random =new Random();
        String code = "";
        for (int i = 0;i < 6;i++){
            code += random.nextInt(10);
        }
        return code;
    }

    //在redis中记录验证码次数和值(一天内只允许手机号注册三次，验证码失效时间为两分钟)
    public void VerifyCode(String phone){
        //记录手机号次数
        String phoneKey = phone + ":count";
        //记录验证码值
        String codeKey = phone + ":code";
        Jedis jedis = Redis.getRedis();
        //查看key中记录的次数
        String count = jedis.get(phoneKey);
        //注册三次后无法注册逻辑
        if (count == null){
            //将key和value插入redis
            jedis.setex(phoneKey,24*60*60,"1");
        }else if (Integer.parseInt(count) <= 2){
            jedis.incr(phoneKey);
        }else{
            System.out.println("手机号今天已经注册三次");
            jedis.close();
            return;
        }

        //将验证码放入redis
        Redis.getRedis().setex(codeKey,120,getCode());
        Redis.closeRedis();
    }

    public String VerifyCodeCheck(String phone,String code){
        String key = phone +":code";
        String redisCode=Redis.getRedis().get(key);
        Redis.closeRedis();
        if (code.equals(redisCode)){
            return "验证成功";
        }else if(redisCode == null){
            return "超时，验证码失效";
        }else
            return "验证失败";
    }
}