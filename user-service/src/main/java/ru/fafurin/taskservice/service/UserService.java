package ru.fafurin.taskservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fafurin.taskservice.domen.Role;
import ru.fafurin.taskservice.domen.User;
import ru.fafurin.taskservice.dto.UserResponse;
import ru.fafurin.taskservice.exception.UserNotFoundException;
import ru.fafurin.taskservice.mapper.UserMapper;
import ru.fafurin.taskservice.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User save(UserResponse userResponse) {
        if (!Objects.equals(userResponse.getPassword(), userResponse.getMatchingPassword())) {
            throw new RuntimeException("Passwords are not equals");
        }
        User user = UserMapper.getUser(new User(), userResponse);
        //TODO: добавить PasswordEncoder
        user.setPassword(userResponse.getPassword());
        user.setRole(Role.USER);


        return userRepository.save(user);
    }

    @Transactional
    public User update(Long id, UserResponse userResponse) {
        User order = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return userRepository.save(
                UserMapper.getUser(order, userResponse));
    }

}
