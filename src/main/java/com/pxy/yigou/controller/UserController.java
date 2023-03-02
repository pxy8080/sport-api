package com.pxy.yigou.controller;

import com.pxy.yigou.entity.User;
import com.pxy.yigou.entity.Result;
import com.pxy.yigou.entity.ResultUtil;
import com.pxy.yigou.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    //UserMapper
    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 获取所有用户信息
     *
     * @return
     */
    @RequestMapping("/getAllUser")
    public Result<List<User>> getAllUser() {
        try {
            List<User> user = userMapper.getAllUser();
            return ResultUtil.success(user, "获取所有用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("获取错误");
    }

    @RequestMapping("/test")
    public Result test() {
        return ResultUtil.success("hello", "测试成功");
    }

    /**
     * 登录
     */
    @RequestMapping("login")
    public Result login(User user) {
        try {
            User res = userMapper.login(user);
            if (res != null)
                return ResultUtil.success(user, "登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.fail("登录失败，失败原因" + e);
        }
        return ResultUtil.fail("登录失败，账号密码错误");
    }



    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping("updateUser")
    public Result updateUser(User user) {
        try {
            userMapper.updateUser(user);
            ResultUtil.success(user, "修改信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.fail("修改信息失败，失败原因" + e);
        }
        return ResultUtil.fail("修改信息失败，请重试");
    }


    /**
     * 注册新用户
     * @return
     */
    @RequestMapping("registerUser")
    public Result registerUser(User user) {
        try {
            int res = userMapper.registerUser(user);
            return res == 1 ? ResultUtil.success(res, "注册成功") : ResultUtil.success(res, "该邮箱已存在！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("注册失败，请重试");
    }

}
