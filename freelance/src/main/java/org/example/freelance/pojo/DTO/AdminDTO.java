package org.example.freelance.pojo.DTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(description = "管理员")
public class AdminDTO implements Serializable {

    @ApiModelProperty("主键值")
    private Long id;
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("状态")
    private String status;

    private LocalDateTime logintime;

    public void setStauts(String i) {
        this.status = i;
    }
}
