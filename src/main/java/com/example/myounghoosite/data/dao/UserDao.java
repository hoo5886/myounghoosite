package com.example.myounghoosite.data.dao;

import com.example.myounghoosite.data.dto.UserChangeDto;
import com.example.myounghoosite.data.entity.User;
import java.util.Optional;

public interface UserDao {

    User insertUser(User user);

    Optional<User> selectUser(Long id);

    User updateUser(Long id, UserChangeDto changeDto) throws Exception;

    void deleteUser(Long id) throws Exception;

}
