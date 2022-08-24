package com.it.user;

import com.it.user.Pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 16622
 * \* Date: 2022/8/4
 * \* Time: 11:12
 * \* Description:
 * \
 */
@SpringBootApplication
@Slf4j
public class  UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    //测试容器对象
    public static void method(){
        ConfigurableApplicationContext run = SpringApplication.run(UserApplication.class);
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        User user01 = run.getBean("user",User.class);
        User user02 = run.getBean("user",User.class);
        System.out.println(user01 == user02);

        System.out.println("-----------------------------------");
        String czw = run.getBean("user").toString();
        //String cx = run.getBean("users").toString();
        //log.info(cx);
        log.info(czw);
    }

}