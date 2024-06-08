package org.example.freelance.Controller.user;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Mapper.UsersMapper;
import org.example.freelance.Service.UsersService;
import org.example.freelance.pojo.DTO.UserDTO;
import org.example.freelance.pojo.Result;
import org.example.freelance.pojo.User;
import org.example.freelance.pojo.DTO.UserLoginDTO;
import org.example.freelance.pojo.VO.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@Slf4j
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;


    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        // 微信登录
        log.info("微信用户登录：{}", userLoginDTO.getCode());
        User user = usersService.wxLogin(userLoginDTO);
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .openid(user.getOpenid())
                .build();
        return Result.success(userLoginVO);
    }

    @PostMapping("/change")
    @ApiOperation("编辑员工信息")
    public Result update(@RequestBody UserDTO userDTO) {
        log.info("编辑员工信息：{}", userDTO);
        usersService.update(userDTO);
        return Result.success();
    }

@PostMapping("/save")
@ApiOperation("新增员工")
public  Result save(@RequestBody UserDTO userDTO){
    log.info("新增员工：{}", userDTO);
    usersService.save(userDTO);
    return Result.success();
}

//    @PostMapping("/user")
//    @ApiOperation("新增员工")
//    public  Result udate(@RequestBody UserDTO userDTO){
//        log.info("新增员工：{}", userDTO);
//        usersService.save(userDTO);
//        return Result.success();
//    }


    @DeleteMapping("delete")
    @ApiOperation("删除员工")
    public  Result delete(@RequestParam List<String> selectedIds){
        log.info("删除人物：{}", selectedIds);
        usersService.deleteBatch(selectedIds);
        return Result.success();
    }

}
