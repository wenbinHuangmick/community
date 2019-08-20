package com.gem.model;

import lombok.Data;

/**
 * @Auther: Mick
 * @Date: 2019/8/17 21:52
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
