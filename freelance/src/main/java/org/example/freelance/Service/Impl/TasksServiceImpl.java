package org.example.freelance.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.freelance.mapper.TasksMapper;
import org.example.freelance.Service.TasksService;
import org.example.freelance.pojo.DTO.TaskDTO;
import org.example.freelance.pojo.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Slf4j
public class TasksServiceImpl implements TasksService {

    @Autowired
    private TasksMapper tasksMapper;


    @Override
    public TaskDTO getById(Long taskId) {
        TaskDTO task= tasksMapper.getById(taskId);
        return task;
    }

    @Override
    public void deleteBatch(List<String> selectedIds) {
        tasksMapper.deleteBatch(selectedIds);
    }

    @Override
    public void save(TaskDTO taskDTO) {
        Task task= new Task();
        BeanUtils.copyProperties(taskDTO,task);
        task.setCreatetime(LocalDateTime.now());
        tasksMapper.insert(task);
    }

    @Override
    public void update(TaskDTO taskDTO) {
        Task task= new Task();
        BeanUtils.copyProperties(taskDTO,task);
        task.setCreatetime(LocalDateTime.now());
        tasksMapper.update(task);
    }

}
