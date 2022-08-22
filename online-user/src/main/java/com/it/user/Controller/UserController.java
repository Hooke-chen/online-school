package com.it.user.Controller;

import com.it.user.Dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 16622
 * \* Date: 2022/8/13
 * \* Time: 11:38
 * \* Description:
 * \
 */
@Slf4j
@RestController
public class UserController {
    @Resource
    private UserDao userDao;

    @GetMapping("/adds/{id}/{name}")
    public void addUser(@PathVariable Map<String,String> user,@CookieValue("_ga") String _ga){
        log.info(user.toString());
        log.info(_ga);

    }

    @PostMapping("/update")
    public void updateUser(){
        //userDao.update(1,"czw");
    }

}