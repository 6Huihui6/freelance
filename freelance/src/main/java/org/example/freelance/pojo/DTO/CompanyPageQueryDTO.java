package org.example.freelance.pojo.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyPageQueryDTO implements Serializable {


    private String search;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
