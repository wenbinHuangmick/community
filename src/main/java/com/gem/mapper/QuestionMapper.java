package com.gem.mapper;

import com.gem.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: Mick
 * @Date: 2019/8/18 21:55
 * @Description:
 */
@Mapper
public interface QuestionMapper {

    //主页sql代码
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) value(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset ,@Param( "size") Integer size);




    //个人页面sql代码
    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") Integer userId, @Param(value ="offset") Integer offset ,@Param(value = "size") Integer size);

    @Select("select count(1) from question where creator=#{userId}")
    Integer countByUserId(@Param("userId") Integer userId);




    //问题详情页面
    @Select("select * from question where id = #{id}")
    Question getById(@Param("id")Integer id);

    @Update("update question set title = #{title} , description = #{description},gmt_modified=#{gmtModified},tag =#{tag} where id=#{id}")
    void update(Question question);
}
