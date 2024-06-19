package org.example.freelance.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.freelance.Mapper.CompaniesMapper;
import org.example.freelance.Service.CompaniesService;
import org.example.freelance.pojo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Slf4j
public class CompaniesServiceImpl implements CompaniesService {

    @Autowired
    private CompaniesMapper companiesMapper;

    @Override
    public void save(Company company) {
        company.setCreatetime(LocalDateTime.now());
        companiesMapper.save(company);

    }

    @Override
    public void deleteBatch(List<String> selectedIds) {
        companiesMapper.deleteBatch(selectedIds);
    }

    @Override
    public void update(Company company) {
        company.setCreatetime(LocalDateTime.now());
        companiesMapper.update(company);
    }
}
