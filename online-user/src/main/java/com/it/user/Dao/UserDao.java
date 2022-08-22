package com.it.user.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.user.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 16622
 * \* Date: 2022/8/11
 * \* Time: 12:06
 * \* Description:
 * \
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {

}
