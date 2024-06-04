package org.example.freelance.pojo.DTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "管理员")
public class AdminDTO implements Serializable {
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("状态")
    private String status;

    public void setStauts(String i) {
        this.status = i;
    }
}
