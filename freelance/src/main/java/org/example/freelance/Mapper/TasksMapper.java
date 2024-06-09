package org.example.freelance.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.freelance.pojo.Task;

import java.util.List;

@Mapper
public interface TasksMapper {


    @Select("select *from tasks where taskid=#{taskId}")
    Task getById(Long taskId);

    @Select("SELECT * FROM tasks")
    List<Task> getAll();

    /**
     * 删除任务
     * @param selectedIds
     */
    void deleteBatch(List<String> selectedIds);

    /**
     * 新增任务
     * @param task
     */
    void insert(Task task);
}
