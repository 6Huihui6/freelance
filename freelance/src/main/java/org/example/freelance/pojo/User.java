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
public class User {
    private Long id; //ID
    private String openid;//微信openid
    private String identity;//身份
    private String name;
    private String age;
    private String sex;
    private String phone;
    private String credit;
    private String payment;
    private String description;
    private String address;
    private LocalDateTime createtime;
    private String avatar;

}
