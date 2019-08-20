package com.gem.model;

import lombok.Data;

/**
 * @Auther: Mick
 * @Date: 2019/8/18 21:58
 * @Description:
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private Integer userId;



}
