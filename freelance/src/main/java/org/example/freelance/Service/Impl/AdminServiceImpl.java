package org.example.freelance.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.freelance.Mapper.AdminMapper;
import org.example.freelance.Mapper.UsersMapper;
import org.example.freelance.Service.AdminService;
import org.example.freelance.Service.UsersService;
import org.example.freelance.exception.AccountNotFoundException;
import org.example.freelance.exception.PasswordErrorException;
import org.example.freelance.pojo.Admin;
import org.example.freelance.pojo.DTO.AdminDTO;
import org.example.freelance.pojo.DTO.UserPageQueryDTO;
import org.example.freelance.pojo.PageResult;
import org.example.freelance.pojo.User;
import org.example.freelance.properties.WeChatProperties;
import org.example.freelance.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(AdminDTO adminDTO) {
        String username = adminDTO.getUsername();
        String password = adminDTO.getPassword();

        Admin admin=adminMapper.getByUsername(username);
        if (admin == null) {
            admin = new Admin();
            admin.setStatus("账号不存在");
        }
        else if (!admin.getPassword().equals(password)) {
            admin.setStatus("用户名或密码错误");
        }
        return admin;
    }

    @Override
    public PageResult pageQuery(UserPageQueryDTO userPageQueryDTO) {
        PageHelper.startPage(userPageQueryDTO.getPage(), userPageQueryDTO.getPageSize());
        Page<User> page = adminMapper.pageQuery(userPageQueryDTO);
        long total = page.getTotal();
        List<User> records = page.getResult();

//        long total = adminMapper.count();
//        int page = userPageQueryDTO.getPage();
//        int pageSize = userPageQueryDTO.getPageSize();
//        int start = (page - 1) * pageSize;
//        int end = page * pageSize;
//        String search = userPageQueryDTO.getSearch();
//        List<User> records = adminMapper.page(start, end, search);
        return new PageResult(total,records);
    }
}
