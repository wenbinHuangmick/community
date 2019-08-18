package com.gem.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: jzhang
 * @Date: 2019/8/8 15:59
 * @Description:
 */
@Data
public class User {
    private Integer id;

    private String username;
    private String password;
    private String sex;

    @Value("${github.client_id}")
    private String clientId;
    @Value("${github.client_secret}")
    private String clientSecret;
    @Value("${github.redirect_uri}")
    private String RedirectUri;
}
