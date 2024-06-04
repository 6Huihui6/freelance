package org.example.freelance.Controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Mapper.UsersMapper;
import org.example.freelance.Service.Impl.UsersServiceImpl;
import org.example.freelance.Service.UsersService;
import org.example.freelance.pojo.Result;
import org.example.freelance.pojo.User;
import org.example.freelance.pojo.VO.UserLoginVO;
import org.example.freelance.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersMapper usersMapper;

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody UserLoginVO userLoginVO) {
        // 微信登录
        String code = userLoginVO.getCode();
        String openid = usersService.getOpenid(code);
        // 添加到数据库
        Integer isRegister = usersMapper.findUser(openid);
        if (isRegister == null) {
            User user = new User();
            user.setOpenid(openid);
            usersMapper.insertUser(user);
        }
        Map<String,String> res = new HashMap<>();
        if (isRegister > 0) {
            // 登录
            log.info("登录");
            res.put("openid",openid);
            res.put("status","登录");
        } else {
            // 注册
            res.put("openid",openid);
            res.put("status","注册");
        }
        return res;
    }
@PostMapping("/user/user")
public Result<User> getByUserId( @PathVariable("userId") Integer userId) {
    return Result.success();
    }



}
