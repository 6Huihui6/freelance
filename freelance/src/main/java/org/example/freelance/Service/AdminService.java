package org.example.freelance.Service;

import org.example.freelance.pojo.Admin;
import org.example.freelance.pojo.DTO.*;
import org.example.freelance.pojo.PageResult;
import org.example.freelance.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminService {

    Admin login(AdminDTO adminDTO);

    /**
     * 分页查询用户
     * @param userPageQueryDTO
     * @return
     */
    @Transactional
    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);


    /**
     * 分页查询任务
     * @param taskPageQueryDTO
     * @return
     */
    PageResult taskPageQuery(TaskPageQueryDTO taskPageQueryDTO);

    /**
     * 分页查询公司
     * @param companyPageQueryDTO
     * @return
     */
    PageResult companyPageQuery(CompanyPageQueryDTO companyPageQueryDTO);

    /**
     * 修改管理员
     * @param adminDTO
     */
    void update(AdminDTO adminDTO);

    void save(AdminDTO adminDTO);

    void deleteBatch(List<String> selectedIds);

    PageResult adminPageQuery(AdminPageQueryDTO adminPageQueryDTO);
}
