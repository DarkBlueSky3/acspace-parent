package com.acspace.user.controller;

import com.acspace.user.po.User;
import com.acspace.user.service.UserService;

import com.acspace.response.ResponseMessage;
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
    public ResponseMessage<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseMessage.success(users);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping
    public ResponseMessage add(@RequestBody User user) {
        userService.add(user);
        return ResponseMessage.success("增加用户成功");
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseMessage delete(@PathVariable String id) {
        userService.delete(Integer.valueOf(id));
        return ResponseMessage.success("删除用户成功");
    }

    /**
     * 修改用户信息
     * @param user
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseMessage update(@RequestBody User user, @PathVariable String id) {
        user.setId(Integer.valueOf(id));
        userService.update(user);
        return ResponseMessage.success("修改用户信息成功");
    }

}
