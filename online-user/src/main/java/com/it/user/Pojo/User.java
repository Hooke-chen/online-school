package com.it.user.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 16622
 * \* Date: 2022/8/11
 * \* Time: 12:52
 * \* Description:
 * \
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private boolean userSex;
    private String userPhone;
    private String userAddress;
}