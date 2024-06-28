package org.example.freelance.Controller.user;

import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Service.ChatsService;
import org.example.freelance.pojo.Chat;
import org.example.freelance.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/chats")
public class ChatsController {

    @Autowired
    private ChatsService chatsService;

    @PostMapping ("/insert")
    public Result insertChat(@RequestBody Chat chat) {
        chatsService.insertChat(chat);
        return Result.success();
    }

    // 获取单个聊天信息
    @GetMapping("/get")
    public Result<List<Chat>> getChat(@RequestParam("openid") String openid,
                                      @RequestParam("channel") String channel) {
        List<Chat> chats = chatsService.getChat(openid, channel);
        return Result.success(chats);
    }

    // 获取所有聊天信息
    @GetMapping("/getAll")
    public Result getAllChat(@RequestParam("openid") String openid) {
        HashMap<String, Object> chats = chatsService.getAllChat();
        return Result.success(chats);
    }

}
