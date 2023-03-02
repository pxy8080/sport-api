package com.pxy.yigou.mapper;

import com.pxy.yigou.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    List<User> getAllUser();

    int registerUser(@Param("user") User user);

    void updateUser(User user);

    User login(@Param("user")User user);
}
