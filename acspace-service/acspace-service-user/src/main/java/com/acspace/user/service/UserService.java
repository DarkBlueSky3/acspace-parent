package com.acspace.user.service;

import com.acspace.user.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> findAll();

    void add(User user);

    void delete(Integer id);

    void update(User user);

}
