package org.example.freelance.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 员工实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long taskid; //ID
    private Long taskcompanyid; //公司ID
    private String taskname; //
    private String taskdesc; //描述
    private String tasktype; //类型
    private String location; //地点
    private double taskpayment; // 金额
    private String taskstatus; //状态
    private String taskTag1;
    private String taskTag2;
    private String taskTag3;
    private LocalDateTime createtime; //创建时间
    private LocalDateTime endtime; //结束时间
    private double longitude; //纬度
    private double latitude; //经度
    private String phone;
}

