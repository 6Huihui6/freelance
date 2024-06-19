package org.example.freelance.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Mapper.ChatsMapper;
import org.example.freelance.Service.ChatsService;
import org.example.freelance.pojo.Chat;
import org.example.freelance.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChatsServiceImpl  implements ChatsService {

    @Autowired
    private ChatsMapper chatsMapper;

    @Override
    public void insertChat(Chat chat) {
        chatsMapper.insertChat(chat);
    }

    @Override
    public List<Chat> getChat(String openid, String channel) {
        return chatsMapper.getChat(openid, channel);
    }
}
