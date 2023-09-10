package com.example.myounghoosite.service;

import com.example.myounghoosite.data.dto.UserChangeDto;
import com.example.myounghoosite.data.dto.UserDto;
import com.example.myounghoosite.data.dto.UserResponseDto;
import java.util.List;

public interface UserService {

    List<UserResponseDto> getUsers();

    UserResponseDto getUser(Long userId);
    UserResponseDto saveUser(UserDto userDto);
    UserResponseDto changeUser(Long userId, UserChangeDto userChangeDto);
    void deleteUser(Long userId) throws Exception;
}
