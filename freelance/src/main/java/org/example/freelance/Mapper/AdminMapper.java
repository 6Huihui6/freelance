package org.example.freelance.Mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.freelance.pojo.Admin;
import org.example.freelance.pojo.Company;
import org.example.freelance.pojo.DTO.*;
import org.example.freelance.pojo.Task;
import org.example.freelance.pojo.User;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("SELECT * FROM admin WHERE username = #{username}")
    public Admin getByUsername(String username) ;


    @Update("UPDATE admin SET logintime = #{logintime} WHERE id = #{id}")
    public void updateLoginTime(long id, LocalDateTime logintime);

    Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO);

    @Select("SELECT COUNT(*) FROM user")
    public int count();
//     public Admin getByUsername(String username) ;

    @Select("SELECT * FROM user WHERE name LIKE CONCAT('%',#{search},'%') LIMIT #{page},#{pageSize}")
    public Page<User> page(int page,int pageSize,String search);

    Page<Task> taskPageQuery(TaskPageQueryDTO taskPageQueryDTO);

    /**
     * 分页查询公司
     * @param companyPageQueryDTO
     * @return
     */
    Page<Company> companyPageQuery(CompanyPageQueryDTO companyPageQueryDTO);


    void update(AdminDTO adminDTO);

    @Insert("insert into admin(username,password) values(#{username},#{password})")
    void save(AdminDTO adminDTO);

    void deleteBatch(List<String> selectedIds);

    Page<Admin> adminPageQuery(AdminPageQueryDTO adminPageQueryDTO);

//    public Admin getAdminByUsername(String username) ;
//     Admin getAdminByUsername(String username) ;
}
