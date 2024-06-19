package org.example.freelance.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private Long companyid;
    private String companyname;
    private String description;
    private String phone;
    private String address;
    private LocalDateTime createtime;

}
