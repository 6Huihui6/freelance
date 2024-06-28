package org.example.freelance.Service;

import org.example.freelance.pojo.Chat;
import org.example.freelance.pojo.Result;

import java.util.HashMap;
import java.util.List;

public interface ChatsService {

    /**
     * Insert a new chat into the database.
     * @param chat
     * @return
     */
    void insertChat(Chat chat);

    List<Chat> getChat(String openid, String channel);

    HashMap<String, Object> getAllChat();
}
