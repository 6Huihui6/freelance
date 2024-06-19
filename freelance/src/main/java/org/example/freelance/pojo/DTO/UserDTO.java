package org.example.freelance.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id; //ID
    private String openid;//微信openid
    private String identity;//身份,  1-老板,2-普通用户
    private String name;
    private String age;
    private String sex;
    private String phone;
    private String payment;
    private String description;
    private String address;
    private String avatar;


}


