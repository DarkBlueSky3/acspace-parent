package com.acspace.user.controller;

import com.acspace.user.po.User;
import com.acspace.user.service.UserService;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping
    public Result<List<User>> findAll() {
        List<User> users = userService.findAll();
        return new Result<>(true, StatusCode.OK, "查询成功", users);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping
    public Result add(@RequestBody User user) {
        userService.add(user);
        return new Result(true, StatusCode.OK, "增加用户成功");
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        userService.delete(Integer.valueOf(id));
        return new Result(true, StatusCode.OK, "删除用户成功");
    }

    /**
     * 修改用户信息
     * @param user
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody User user, @PathVariable String id) {
        user.setId(Integer.valueOf(id));
        userService.update(user);
        return new Result(true, StatusCode.OK, "修改用户信息成功");
    }

}
