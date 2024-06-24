package org.example.freelance.Controller.admin;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Service.AdminService;
import org.example.freelance.pojo.Admin;
import org.example.freelance.pojo.DTO.*;
import org.example.freelance.pojo.PageResult;
import org.example.freelance.pojo.Result;
import org.example.freelance.pojo.VO.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
                .logintime(LocalDateTime.now())
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

    @GetMapping("/tasks/page")
    @ApiOperation("任务分页查询")
    public  Result<PageResult>page(TaskPageQueryDTO taskPageQueryDTO){
        log.info("任务分页查询：{}", taskPageQueryDTO.toString());
        PageResult pageResult =adminService.taskPageQuery(taskPageQueryDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/companies/page")
    @ApiOperation("公司分页查询")
    public  Result<PageResult>page(CompanyPageQueryDTO companyPageQueryDTO){
        log.info("公司分页查询：{}", companyPageQueryDTO.toString());
        PageResult pageResult =adminService.companyPageQuery(companyPageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/update")
    @ApiOperation("编辑员工信息")
    public Result update(@RequestBody AdminDTO adminDTO) {
        log.info("编辑员工信息：{}", adminDTO);
        adminService.update(adminDTO);
        return Result.success();
    }

    @PostMapping("/save")
    @ApiOperation("新增管理员")
    public  Result save(@RequestBody AdminDTO adminDTO){
        log.info("新增员工：{}", adminDTO);
        adminService.save(adminDTO);
        return Result.success();
    }

    @DeleteMapping("delete")
    @ApiOperation("删除员工")
    public  Result delete(@RequestParam List<String> selectedIds){
        log.info("删除人物：{}", selectedIds);
        adminService.deleteBatch(selectedIds);
        return Result.success();
    }

    @GetMapping("/admin/page")
    @ApiOperation("员工分页查询")
    public  Result<PageResult>page(AdminPageQueryDTO adminPageQueryDTO){
        log.info("员工分页查询：{}", adminPageQueryDTO.toString());
        PageResult pageResult =adminService.adminPageQuery(adminPageQueryDTO);
        return Result.success(pageResult);
    }

}