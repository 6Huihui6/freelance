package org.example.freelance.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.example.freelance.Mapper.UsersMapper;
import org.example.freelance.Service.UsersService;
import org.example.freelance.properties.WeChatProperties;
import org.example.freelance.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    

}
