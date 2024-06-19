package org.example.freelance.Controller.user;

import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Service.ChatsService;
import org.example.freelance.pojo.Chat;
import org.example.freelance.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get")
    public Result<List<Chat>> getChat(@RequestParam("openid") String openid,
                                      @RequestParam("channel") String channel) {
        List<Chat> chats = chatsService.getChat(openid, channel);
        return Result.success(chats);
    }


}
