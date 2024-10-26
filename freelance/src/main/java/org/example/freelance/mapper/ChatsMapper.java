package org.example.freelance.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.freelance.pojo.Chat;

import java.util.List;

@Mapper
public interface ChatsMapper {


    @Insert("insert into chats (openid, time, channel,content) values (#{openid}, #{time}, #{channel}, #{content})")
     void insertChat(Chat chat) ;

    @Select("select * from chats where  channel = #{channel} order by time")
    List<Chat> getChat(String openid, String channel);

    @Select("SELECT * FROM chats WHERE channel LIKE concat('%','oTASb62kOCTVV1hhy8QkavgJkfp8','%') ORDER BY time DESC")
    List<Chat> getAllChat();
}
