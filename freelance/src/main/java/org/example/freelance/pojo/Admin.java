package org.example.freelance.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
public class Admin   {

    private Long id;
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;
    private LocalDateTime logintime;
    private String status;

}
