package org.example.freelance.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.freelance.pojo.Company;

import java.util.List;
import java.util.Map;

@Mapper
public interface CompaniesMapper {

    /**
     * 保存公司信息
     * @param company
     */
    void save(Company company);

    /**
     * 删除公司信息
     * @param selectedIds
     */
    void deleteBatch(List<String> selectedIds);

    /**
     * 修改公司信息
     * @param company
     */
    void update(Company company);

    Integer countByMap(Map map);
}
