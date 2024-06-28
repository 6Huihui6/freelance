package org.example.freelance.Service.Impl;

import org.example.freelance.mapper.CompaniesMapper;
import org.example.freelance.mapper.TasksMapper;
import org.example.freelance.mapper.UsersMapper;
import org.example.freelance.Service.ReportService;
import org.example.freelance.pojo.VO.CompanyReportVO;
import org.example.freelance.pojo.VO.TaskReportVO;
import org.example.freelance.pojo.VO.UserReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CompaniesMapper companiesMapper;
    @Autowired
    private TasksMapper tasksMapper;

    @Override
    public UserReportVO getuserStatistics(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dateList=new ArrayList<>();
        dateList.add(startDate);
        while (!startDate.equals(endDate)){
            startDate=startDate.plusDays(1);
            dateList.add(startDate);
        }
        //总用户数
        List<Integer> totalUserList=new ArrayList<>();
        for (LocalDate date : dateList) {
            LocalDateTime beginTine = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTine = LocalDateTime.of(date, LocalTime.MAX);
            Map map=new HashMap();
            map.put("endDate",endTine);
            Integer totalUser=usersMapper.countByMap(map);
            map.put("startDate",beginTine);
            totalUserList.add(totalUser);
        }
        return UserReportVO
                .builder()
                .dateList(dateList)
                .totalUserList(totalUserList)
                .build();
    }

    @Override
    public CompanyReportVO getcompanyStatistics(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dateList=new ArrayList<>();
        dateList.add(startDate);

        while (!startDate.equals(endDate)){
            startDate=startDate.plusDays(1);
            dateList.add(startDate);
        }
        //总用户数
        List<Integer> totalUserList=new ArrayList<>();
        for (LocalDate date : dateList) {
            LocalDateTime beginTine = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTine = LocalDateTime.of(date, LocalTime.MAX);
            Map map=new HashMap();
            map.put("endDate",endTine);
            Integer totalUser=companiesMapper.countByMap(map);
            map.put("startDate",beginTine);
            totalUserList.add(totalUser);
        }

        return CompanyReportVO
                .builder()
                .dateList(dateList)
                .totalUserList(totalUserList)
                .build();
    }

    @Override
    public TaskReportVO gettaskStatistics(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dateList=new ArrayList<>();
        dateList.add(startDate);

        while (!startDate.equals(endDate)){
            startDate=startDate.plusDays(1);
            dateList.add(startDate);
        }
        //总用户数
        List<Integer> totalUserList=new ArrayList<>();
        for (LocalDate date : dateList) {
            LocalDateTime beginTine = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTine = LocalDateTime.of(date, LocalTime.MAX);
            Map map=new HashMap();
            map.put("endDate",endTine);
            Integer totalUser=tasksMapper.countByMap(map);
            map.put("startDate",beginTine);
            totalUserList.add(totalUser);
        }

        return TaskReportVO
                .builder()
                .dateList(dateList)
                .totalUserList(totalUserList)
                .build();
    }
}





