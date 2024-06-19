package org.example.freelance.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.freelance.pojo.DTO.TaskDTO;
import org.example.freelance.pojo.Task;

import java.util.List;
import java.util.Map;

@Mapper
public interface TasksMapper {


    @Select("select *from tasks where taskid=#{taskId}")
    TaskDTO getById(Long taskId);

    @Select("SELECT *  FROM tasks LEFT JOIN freelanceplatform.company ON company.companyid = tasks.taskcompanyid")
    List<TaskDTO> getAll();

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

    /**
     * 更新任务
     * @param task
     */
    void update(Task task);

    Integer countByMap(Map map);
}
