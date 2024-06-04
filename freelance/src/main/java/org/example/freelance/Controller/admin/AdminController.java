package org.example.freelance.Controller.admin;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Service.AdminService;
import org.example.freelance.pojo.Admin;
import org.example.freelance.pojo.DTO.AdminDTO;
import org.example.freelance.pojo.DTO.UserPageQueryDTO;
import org.example.freelance.pojo.PageResult;
import org.example.freelance.pojo.Result;
import org.example.freelance.pojo.VO.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result<AdminVO> login(@RequestBody AdminDTO adminDTO){
    adminDTO.setStauts("1");
        System.out.println("------------------------------,{}"+adminDTO.toString());

        Admin admin=adminService.login(adminDTO);

        AdminVO adminVO=AdminVO.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .status(admin.getStatus())
                .build();

        return Result.success(adminVO);
}


    @GetMapping("/user/page")
    @ApiOperation("员工分页查询")
    public  Result<PageResult>page(UserPageQueryDTO userPageQueryDTO){
        log.info("员工分页查询：{}", userPageQueryDTO.toString());
        PageResult pageResult =adminService.pageQuery(userPageQueryDTO);
        return Result.success(pageResult);
    }



}