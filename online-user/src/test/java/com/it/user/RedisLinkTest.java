package com.it.user;

import com.it.user.Util.PhoneCode;
import com.it.user.Util.Redis;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 16622
 * \* Date: 2022/8/4
 * \* Time: 11:27
 * \* Description:
 * \
 */
@SpringBootTest
public class RedisLinkTest {

    private Jedis jedis= Redis.getRedis();
    private PhoneCode phoneCode =new PhoneCode();
    private String phone = "13052960961";

    @Test
    public void pingTest(){
        String value = jedis.ping();
        System.out.println(value);
        jedis.close();
    }

    @Test
    public void setTest(){
        //遍历所有key
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }

        String value = jedis.get("a");
        System.out.println(value);
        jedis.close();
    }

    @Test
    //测试获取验证码
    public void getPhoneCodeTest(){
        System.out.println(phoneCode.getCode());
    }
    @Test
    //测试验证码获取逻辑
    public void VerifyCodeTest(){
        phoneCode.VerifyCode(phone);
        int count = Integer.parseInt(jedis.get(phone + ":count"));
        String code = jedis.get(phone + ":code");
        System.out.println("count:" + count + ";" + "code:" + code);
        jedis.close();
    }
    @Test
    public void VerifyCodeCheckTest(){
        System.out.println(phoneCode.VerifyCodeCheck(phone,"895352"));
    }
}