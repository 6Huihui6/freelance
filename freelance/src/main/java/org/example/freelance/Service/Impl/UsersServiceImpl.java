package org.example.freelance.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.example.freelance.Mapper.UsersMapper;
import org.example.freelance.Service.UsersService;
import org.example.freelance.exception.LoginFailedException;
import org.example.freelance.pojo.DTO.UserDTO;
import org.example.freelance.pojo.DTO.UserLoginDTO;
import org.example.freelance.pojo.User;
import org.example.freelance.properties.WeChatProperties;
import org.example.freelance.utils.HttpClientUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    private static final String WX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    private WeChatProperties weChatProperties; // 注入微信配置类

    @Autowired
    private UsersMapper usersMapper;

    public String getOpenid(String code) {
        // 获取用户的openid
        String WX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session?appid=wxbdec8406a033c5aa&secret=6fd234daff71c32dbd41ebaa42709b2f&js_code="+code+"&grant_type=authorization_code";
        String json = HttpClientUtil.doGet(WX_LOGIN, new HashMap<>());
        JSONObject jsonObject = JSON.parseObject(json);
        String openid = jsonObject.getString("openid");
        return openid;
    }

    @Override
    public User wxLogin(UserLoginDTO userLoginDTO) {
        String openid = getOpenid(userLoginDTO.getCode());

        //判断openid是否为空，如果为空表示登录失败，抛出业务异常
        if(openid == null){
            throw new LoginFailedException("登录失败");
        }

        //判断当前用户是否为新用户
        User user = usersMapper.getByOpenid(openid);

        //如果是新用户，自动完成注册
        if(user == null){
            user = User.builder()
                    .openid(openid)
                    .createtime(LocalDateTime.now())
                    .build();
            usersMapper.insert(user);
        }

        //返回这个用户对象
        return user;
    }

    /**
     * 更新用户信息
     * @param userDTO
     */
    @Override
    public void update(UserDTO userDTO) {
        User user =new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setCreatetime(LocalDateTime.now());
        usersMapper.update(user);
    }

    @Override
    public void save(UserDTO userDTO) {
        User user =new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setCreatetime(LocalDateTime.now());
        usersMapper.insert(user);
    }

    /**
     * 根据id删除
     * @param selectedIds
     */
    @Transactional
    @Override
    public void deleteBatch(List<String> selectedIds) {
        usersMapper.deleteBatch(selectedIds);
    }

    @Override
    public List<User> getFreelance() {
        return usersMapper.getFreelance();
    }

}
