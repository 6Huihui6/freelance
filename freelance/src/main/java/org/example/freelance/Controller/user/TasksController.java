package org.example.freelance.Controller.user;

import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Mapper.TasksMapper;
import org.example.freelance.Service.TasksService;
import org.example.freelance.pojo.Result;
import org.example.freelance.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
@Slf4j
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @Autowired
    private TasksMapper tasksMapper;

    @GetMapping("/{taskId}")
    public Result<Task> getById(@PathVariable("taskId") Long taskId) {
        log.info("测试：{}",taskId);
        Task task = tasksService.getById(taskId);
        return Result.success(task);
    }

    @GetMapping
    public Result getAll() {
        List<Task> res = tasksMapper.getAll();
        return Result.success(res) ;
    }



}