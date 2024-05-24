package org.example.freelance.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Mapper.TasksMapper;
import org.example.freelance.Service.TasksService;
import org.example.freelance.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class TasksServiceImpl implements TasksService {

    @Autowired
    private TasksMapper tasksMapper;


    @Override
    public Task getById(Long taskId) {
        Task task= tasksMapper.getById(taskId);
        return task;
    }



}
