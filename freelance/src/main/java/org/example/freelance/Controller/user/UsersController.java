package org.example.freelance.Controller.user;


import io.goeasy.GoEasy;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.freelance.mapper.UsersMapper;
import org.example.freelance.Service.UsersService;
import org.example.freelance.pojo.DTO.UserDTO;
import org.example.freelance.pojo.Result;
import org.example.freelance.pojo.User;
import org.example.freelance.pojo.DTO.UserLoginDTO;
import org.example.freelance.pojo.VO.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersMapper usersMapper;

    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        // 微信登录
        log.info("微信用户登录：{}", userLoginDTO.getCode());
        User user = usersService.wxLogin(userLoginDTO);
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .openid(user.getOpenid())
                .build();
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io",
                "BC-25fd9eb4937f4ee4a886430b46999400");
        //参数：管道标识，发送内容
        goEasy.publish("客户端", "Hello, GoEasy!");
        return Result.success(userLoginVO);
    }
@GetMapping("/getUser")
public Result<User> getUser(@RequestParam String openid) {
        log.info("查询用户：{}", openid);
    User user = usersMapper.getByOpenid(openid);
        return Result.success(user);
    }
    @PostMapping("/update")
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

@GetMapping("/freelance")
public Result getFreelance() {
        List<User> freelance = usersService.getFreelance();
        return Result.success(freelance);
}


    @DeleteMapping("delete")
    @ApiOperation("删除员工")
    public  Result delete(@RequestParam List<String> selectedIds){
        log.info("删除人物：{}", selectedIds);
        usersService.deleteBatch(selectedIds);
        return Result.success();
    }

}
