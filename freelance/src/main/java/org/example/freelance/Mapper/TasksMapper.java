package org.example.freelance.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.freelance.pojo.Task;

import java.util.List;

@Mapper
public interface TasksMapper {


    @Select("select *from tasks where task_Id=#{taskId}")
    Task getById(Long taskId);

    @Select("SELECT * FROM tasks")
    List<Task> getAll();
}
