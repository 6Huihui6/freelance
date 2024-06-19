package org.example.freelance.Controller.user;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Service.CompaniesService;
import org.example.freelance.Service.UsersService;
import org.example.freelance.pojo.Company;
import org.example.freelance.pojo.DTO.UserDTO;
import org.example.freelance.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/companies")
public class CompaniesController {
    @Autowired
    private CompaniesService companiesService;

    @PostMapping("/update")
    @ApiOperation("编辑公司信息")
    public Result update(@RequestBody Company company) {
        log.info("编辑公司信息：{}", company);
        companiesService.update(company);
        return Result.success();
    }

@PostMapping("/save")
@ApiOperation("新增公司")
public  Result save(@RequestBody Company company){
    log.info("新增公司：{}", company);
    companiesService.save(company);
    return Result.success();
}

//    @PostMapping("/user")
//    @ApiOperation("新增员工")
//    public  Result udate(@RequestBody UserDTO userDTO){
//        log.info("新增员工：{}", userDTO);
//        usersService.save(userDTO);
//        return Result.success();
//    }


    @DeleteMapping("delete")
    @ApiOperation("删除公司")
    public  Result delete(@RequestParam List<String> selectedIds){
        log.info("删除公司：{}", selectedIds);
        companiesService.deleteBatch(selectedIds);
        return Result.success();
    }

}
