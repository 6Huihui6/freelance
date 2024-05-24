package org.example.freelance.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Freelance {

    private Long id; //ID
    private String openid; //
    private String userPassword; //密码
    private Short userSex; //性别 , 1 男, 2 女
    private String userPhone; //手机号
    private String userCredit; //信用分
    private Short userIdentity; //  身份 , 1 零工 , 2 公司
    private String userDescription; //描述
    private LocalDateTime userCreatetime; //创建时间
    private String image; //图像url
}
