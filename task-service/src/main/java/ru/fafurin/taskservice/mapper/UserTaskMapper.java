package ru.fafurin.taskservice.mapper;

import ru.fafurin.taskservice.domen.UserTask;
import ru.fafurin.taskservice.dto.UserTaskResponse;

public class UserTaskMapper {

    public static UserTask getUserTask(UserTask userTask, UserTaskResponse userTaskResponse) {
        userTask.setTitle(userTaskResponse.getTitle());
        return userTask;
    }
}
