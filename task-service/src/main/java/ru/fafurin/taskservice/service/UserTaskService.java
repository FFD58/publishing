package ru.fafurin.taskservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fafurin.taskservice.domen.Status;
import ru.fafurin.taskservice.domen.UserTask;
import ru.fafurin.taskservice.dto.UserTaskResponse;
import ru.fafurin.taskservice.exception.UserTaskNotFoundException;
import ru.fafurin.taskservice.mapper.UserTaskMapper;
import ru.fafurin.taskservice.repository.UserTaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTaskService {

    private final UserTaskRepository userTaskRepository;
//    private final WebClient.Builder webClientBuilder;

    public List<UserTask> getAll() {
        return userTaskRepository.findAll();
    }

    public UserTask save(UserTaskResponse userTaskResponse) {
        UserTask userTask = UserTaskMapper.getUserTask(new UserTask(), userTaskResponse);

        Long userId = userTaskResponse.getUserId();
        Long orderId = userTaskResponse.getOrderId();

        //TODO: проверить id заказа в микросервисе order-service

        userTask.setOrderId(orderId);
        userTask.setUserId(userId);
        userTask.setStatus(Status.IN_WORK);
        return userTaskRepository.save(userTask);
    }

    @Transactional
    public UserTask update(Long id, UserTaskResponse userTaskResponse) {
        UserTask order = userTaskRepository.findById(id)
                .orElseThrow(() -> new UserTaskNotFoundException(id));

        return userTaskRepository.save(
                UserTaskMapper.getUserTask(order, userTaskResponse));
    }

}
