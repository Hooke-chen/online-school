package com.it.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * \* author: czw
 * \* email: 1662279084@qq.com
 * \* Date: 2022/8/23
 * \* Version:
 * \* Description:
 * \
 */
@SpringBootApplication
@ComponentScan(value = "com.it")
public class EduApplication {
    public static void main(String[] args) {
       SpringApplication.run(EduApplication.class, args);

    }
}