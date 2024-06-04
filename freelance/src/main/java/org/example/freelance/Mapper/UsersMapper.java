package org.example.freelance.Mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.example.freelance.pojo.User;

@Mapper
public interface UsersMapper {

    @Select("SELECT COUNT(*) FROM users WHERE openid = #{openid}")
    Integer findUser(String openid);






    @Insert("insert into users(openid) values#{openid}")
    void insertUser(User user);
}
