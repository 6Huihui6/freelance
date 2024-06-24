package org.example.freelance.Mapper;


import org.apache.ibatis.annotations.*;
import org.example.freelance.pojo.User;
import org.example.freelance.pojo.VO.SalaryRange;

import java.util.List;
import java.util.Map;

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

    /**
     * 删除员工信息
     */
    void deleteBatch(List<String> selectedIds);


    Integer countByMap(Map map);


    List<SalaryRange> getSalaryRangeData();

    @Select("SELECT * FROM user WHERE identity = '零工'")
    List<User> getFreelance();
}
