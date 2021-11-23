package com.acspace.user.service;

import com.acspace.user.po.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void add(User user);

    void delete(Integer id);

    void update(User user);

}
