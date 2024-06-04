package org.example.freelance.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminVO {

    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("状态")
    private String status;
}
