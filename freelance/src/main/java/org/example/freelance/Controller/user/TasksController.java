package org.example.freelance.Controller.user;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.freelance.mapper.TasksMapper;
import org.example.freelance.Service.TasksService;
import org.example.freelance.pojo.DTO.TaskDTO;
import org.example.freelance.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
@Slf4j
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @Autowired
    private TasksMapper tasksMapper;

    @GetMapping("/{taskId}")
    public Result<TaskDTO> getById(@PathVariable("taskId") Long taskId) {
        log.info("测试：{}",taskId);
        TaskDTO task = tasksService.getById(taskId);
        return Result.success(task);
    }

    @GetMapping
    public Result getAll() {
        List<TaskDTO> res = tasksMapper.getAll();
        return Result.success(res) ;
    }

    @PostMapping("/save")
    @ApiOperation("新增任务")
    public  Result save(@RequestBody TaskDTO taskDTO){
        log.info("新增任务：{}", taskDTO);
        tasksService.save(taskDTO);
        return Result.success();
    }

    @DeleteMapping("delete")
    @ApiOperation("删除任务")
    public  Result delete(@RequestParam List<String> selectedIds){
        log.info("删除任务：{}", selectedIds);
        tasksService.deleteBatch(selectedIds);
        return Result.success();
    }

    @PostMapping("/update")
    @ApiOperation("编辑任务信息")
    public Result update(@RequestBody TaskDTO taskDTO) {
        log.info("编辑任务信息：{}", taskDTO);
        tasksService.update(taskDTO);
        return Result.success();
    }


}
