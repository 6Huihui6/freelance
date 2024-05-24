package org.example.freelance.Mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Select("SELECT COUNT(*) FROM users WHERE openid = #{openid}")
    Integer findUser(String openid);


    void register();
}
