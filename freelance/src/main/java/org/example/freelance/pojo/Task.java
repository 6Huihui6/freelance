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
    private Long taskId; //ID
    private Long taskcompanyId; //公司ID
    private String taskName; //用户名
    private String taskDescription; //描述
    private String taskType; //类型
    private String taskLocation; //地点
    private double taskPayment; // 金额
    private String taskStatus; //状态
    private String taskTag1;
    private String taskTag2;
    private String taskTag3;
    private LocalDateTime taskCreatetime; //创建时间
    private LocalDateTime taskEndtime; //结束时间
    private double taskLatitude; //纬度
    private double taskLongitude; //经度
}
