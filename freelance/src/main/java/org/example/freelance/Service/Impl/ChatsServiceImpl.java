package org.example.freelance.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Mapper.ChatsMapper;
import org.example.freelance.Service.ChatsService;
import org.example.freelance.pojo.Chat;
import org.example.freelance.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

    @Override
    public HashMap<String, Object> getAllChat() {
        List<Chat> chattings = chatsMapper.getAllChat();
        HashMap<String, Object> res = new HashMap<>();
        for (Chat c : chattings) {
            String channel = c.getChannel();
            if (!res.containsKey(channel)) {
                res.put(channel,c);
            }
        }
        return res;
    }
}
