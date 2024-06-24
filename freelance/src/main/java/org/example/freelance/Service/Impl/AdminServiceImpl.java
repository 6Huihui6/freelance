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
import org.example.freelance.pojo.*;
import org.example.freelance.pojo.DTO.*;
import org.example.freelance.properties.WeChatProperties;
import org.example.freelance.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        else if (! admin.getPassword().equals(password)) {
            admin.setStatus("用户名或密码错误");
        } else {
            adminMapper.updateLoginTime(admin.getId(),LocalDateTime.now());
            admin=adminMapper.getByUsername(username);
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

    @Override
    public PageResult taskPageQuery(TaskPageQueryDTO taskPageQueryDTO) {
        PageHelper.startPage(taskPageQueryDTO.getPage(), taskPageQueryDTO.getPageSize());
        Page<Task> page = adminMapper.taskPageQuery(taskPageQueryDTO);
        long total = page.getTotal();
        List<Task> records = page.getResult();
        return new PageResult(total,records);
    }

    @Override
    public PageResult companyPageQuery(CompanyPageQueryDTO companyPageQueryDTO) {
        PageHelper.startPage(companyPageQueryDTO.getPage(), companyPageQueryDTO.getPageSize());
        Page<Company> page = adminMapper.companyPageQuery(companyPageQueryDTO);
        long total = page.getTotal();
        List<Company> records = page.getResult();
        return new PageResult(total,records);
    }

    @Override
    public void update(AdminDTO adminDTO) {
        adminMapper.update(adminDTO);
    }

    @Override
    public void save(AdminDTO adminDTO) {

        adminMapper.save(adminDTO
        );
    }

    @Override
    public void deleteBatch(List<String> selectedIds) {
        adminMapper.deleteBatch(selectedIds);
    }

    @Override
    public PageResult adminPageQuery(AdminPageQueryDTO adminPageQueryDTO) {
        PageHelper.startPage(adminPageQueryDTO.getPage(), adminPageQueryDTO.getPageSize());
        Page<Admin> page = adminMapper.adminPageQuery(adminPageQueryDTO);
        long total = page.getTotal();
        List<Admin> records = page.getResult();
        return new PageResult(total,records);
    }
}
