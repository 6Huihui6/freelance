package org.example.freelance.Mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.freelance.pojo.Admin;
import org.example.freelance.pojo.DTO.UserPageQueryDTO;
import org.example.freelance.pojo.User;

@Mapper
public interface AdminMapper {
    @Select("SELECT * FROM admin WHERE username = #{username}")
    public Admin getByUsername(String username) ;


    Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO);

    @Select("SELECT COUNT(*) FROM users")
    public int count();
//     public Admin getByUsername(String username) ;

    @Select("SELECT * FROM users WHERE name LIKE CONCAT('%',#{search},'%') LIMIT #{page},#{pageSize}")
    public Page<User> page(int page,int pageSize,String search);

//    public Admin getAdminByUsername(String username) ;
//     Admin getAdminByUsername(String username) ;
}
