package com.gem.mapper;

import com.gem.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: jzhang
 * @Date: 2019/8/8 16:03
 * @Description: 用户接口
 */
//@Mapper
//@Repository
public interface UserMappersss {
    //插入方法
    @Insert("insert into s_user(username,password,sex) values(#{username},#{password},#{sex})")
    int insert(User user);

    //根据用户名查询用户
    @Select("select * from s_user where username = #{username}")
    User selectOne(String username);

    //查询集合
    @Select("select username username_,password password_ from s_user")
    //实现查询列和实体类属性的映射
    @Results({
            @Result(property = "username",column = "username_"),
            @Result(property = "password",column = "password_")
    })
    List<User> selectList();
}
