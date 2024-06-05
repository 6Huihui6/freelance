package org.example.freelance.Service;

import org.example.freelance.pojo.DTO.UserDTO;
import org.example.freelance.pojo.DTO.UserLoginDTO;
import org.example.freelance.pojo.User;

public interface UsersService {
    String getOpenid(String code);


    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);

    /**
     * 更新员工信息
     * @param userDTO
     */
    void update(UserDTO userDTO);

    /**
     * 保存员工信息
     * @param userDTO
     */
    void save(UserDTO userDTO);
}
