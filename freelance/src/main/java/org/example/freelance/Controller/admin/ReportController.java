package org.example.freelance.Controller.admin;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Mapper.UsersMapper;
import org.example.freelance.Service.AdminService;
import org.example.freelance.Service.ReportService;
import org.example.freelance.pojo.Admin;
import org.example.freelance.pojo.DTO.AdminDTO;
import org.example.freelance.pojo.DTO.CompanyPageQueryDTO;
import org.example.freelance.pojo.DTO.TaskPageQueryDTO;
import org.example.freelance.pojo.DTO.UserPageQueryDTO;
import org.example.freelance.pojo.PageResult;
import org.example.freelance.pojo.Result;
import org.example.freelance.pojo.VO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;
    @Autowired
    private UsersMapper usersMapper;

        @GetMapping("/userStatistics")
    @ApiOperation("用户统计")
    public Result<UserReportVO> userStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        log.info("用户统计开始时间：{}，结束时间：{}", startDate, endDate);
        return Result.success(reportService.getuserStatistics(startDate, endDate));

    }

        @GetMapping("/companyStatistics")
    @ApiOperation("用户统计")
    public Result<CompanyReportVO> companyStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        log.info("公司统计开始时间：{}，结束时间：{}", startDate, endDate);
        return Result.success(reportService.getcompanyStatistics(startDate, endDate));

    }

    @GetMapping("/taskStatistics")
    @ApiOperation("任务统计")
    public Result<TaskReportVO> taskStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        log.info("任务统计开始时间：{}，结束时间：{}", startDate, endDate);
        return Result.success(reportService.gettaskStatistics(startDate, endDate));
    }

    @GetMapping("/pieChartData")
    public List<Map<String, Object>> getPieChartData() {
            log.info("获取薪资范围数据");
        List<SalaryRange> salaryRanges = usersMapper.getSalaryRangeData();
        List<Map<String, Object>> pieChartData = new ArrayList<>();

        for (SalaryRange range : salaryRanges) {
            Map<String, Object> data = new HashMap<>();
            data.put("name", range.getSalaryRange());
            data.put("value", range.getUserCout());
            pieChartData.add(data);
        }

        return pieChartData;
    }

}