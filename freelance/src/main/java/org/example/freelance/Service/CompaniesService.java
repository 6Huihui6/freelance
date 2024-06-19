package org.example.freelance.Service;

import org.example.freelance.pojo.Company;

import java.util.List;

public interface CompaniesService {


    /**
     * 新增公司
     * @param company
     */
    void save(Company company);

    /**
     * 删除公司
     * @param selectedIds
     */
    void deleteBatch(List<String> selectedIds);

    /**
     * x修改公司
     * @param company
     */
    void update(Company company);
}
