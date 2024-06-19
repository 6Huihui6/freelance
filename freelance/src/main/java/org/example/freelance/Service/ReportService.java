package org.example.freelance.Service;



import org.example.freelance.pojo.VO.CompanyReportVO;
import org.example.freelance.pojo.VO.TaskReportVO;
import org.example.freelance.pojo.VO.UserReportVO;

import java.time.LocalDate;

public interface ReportService {


    /**
     * 用户统计
     * @param startDate
     * @param endDate
     * @return
     */
    UserReportVO getuserStatistics(LocalDate startDate, LocalDate endDate);

    /**
     * 公司统计
     * @param startDate
     * @param endDate
     * @return
     */
    CompanyReportVO getcompanyStatistics(LocalDate startDate, LocalDate endDate);

    /**
     * 任务统计
     * @param startDate
**/
    TaskReportVO gettaskStatistics(LocalDate startDate, LocalDate endDate);
}
