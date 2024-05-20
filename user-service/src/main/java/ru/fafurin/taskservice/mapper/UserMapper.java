package ru.fafurin.taskservice.mapper;

import ru.fafurin.taskservice.domen.User;
import ru.fafurin.taskservice.dto.UserResponse;

public class UserMapper {

    public static User getUser(User user, UserResponse userResponse) {
        user.setEmail(userResponse.getEmail());
        user.setUsername(userResponse.getUsername());
        return user;
    }
}
