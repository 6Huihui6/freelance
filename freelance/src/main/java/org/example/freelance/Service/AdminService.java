package org.example.freelance.Service;

import org.example.freelance.pojo.Admin;
import org.example.freelance.pojo.DTO.AdminDTO;
import org.example.freelance.pojo.DTO.UserPageQueryDTO;
import org.example.freelance.pojo.PageResult;
import org.example.freelance.pojo.User;
import org.springframework.transaction.annotation.Transactional;

public interface AdminService {

    Admin login(AdminDTO adminDTO);

    /**
     * 分页查询用户
     * @param userPageQueryDTO
     * @return
     */
    @Transactional
    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);


}
