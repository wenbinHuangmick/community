package com.gem.dto;

import com.gem.model.Question;
import com.gem.model.User;
import lombok.Data;

/**
 * @Auther: Mick
 * @Date: 2019/8/18 22:38
 * @Description:
 */
@Data
public class QuestionDTO {
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

    private User user;
}
