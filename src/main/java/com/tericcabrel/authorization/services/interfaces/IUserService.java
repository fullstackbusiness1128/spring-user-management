package com.tericcabrel.authorization.services.interfaces;

import java.util.List;

import com.tericcabrel.authorization.dtos.UpdatePasswordDto;
import com.tericcabrel.authorization.dtos.UpdateUserDto;
import com.tericcabrel.authorization.dtos.UserDto;
import com.tericcabrel.authorization.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User save(UserDto userDto);

    List<User> findAll();

    void delete(String id);

    User findByEmail(String email);

    User findById(String id);

    User update(String id, UpdateUserDto updateUserDto);

    void update(User user);

    User updatePassword(String id, UpdatePasswordDto updatePasswordDto);

    User updatePassword(String id, String newPassword);
}
