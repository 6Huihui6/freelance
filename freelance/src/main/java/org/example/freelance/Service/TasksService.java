package org.example.freelance.Service;

import org.example.freelance.pojo.DTO.TaskDTO;
import org.example.freelance.pojo.Task;

import java.util.List;


public interface TasksService {


    TaskDTO getById(Long taskId);

    /**
     * 删除任务
     * @param selectedIds
     */
    void deleteBatch(List<String> selectedIds);

    /**
     * 保存任务
     * @param taskDTO
     */
    void save(TaskDTO taskDTO);

    /**
     * 更新任务
     * @param taskDTO
     */
    void update(TaskDTO taskDTO);
}
