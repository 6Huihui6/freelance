package org.example.freelance.Mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.example.freelance.pojo.User;

@Mapper
public interface UsersMapper {

    @Select("SELECT * FROM user WHERE openid = #{openid}")
    User getByOpenid(String openid);


    void insert(User user);


    /**
     * 编辑员工信息
     * @param user
     */
    void update(User user);
}
