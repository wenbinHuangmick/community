package com.gem.dto;

import lombok.Data;

/**
 * @Auther: Mick
 * @Date: 2019/8/17 13:57
 * @Description:
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
