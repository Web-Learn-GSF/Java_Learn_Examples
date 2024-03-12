package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;


public interface ReportService {

    /**
     * 获取统计营业额
     * @param begin
     * @param end
     * @return
     */
    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);

    /**
     *
     * @param begin
     * @param end
     * @return
     */
    TurnoverReportVO getTurnoverStatisticsGsf(LocalDate begin, LocalDate end);

    /**
     * 用户数量统计
     * @param begin
     * @param end
     * @return
     */
    UserReportVO getUserSratistics(LocalDate begin, LocalDate end);

    /**
     * 订单统计
     * @param begin
     * @param end
     * @return
     */
    OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

    /**
     * 获取销量前十的菜品
     * @param begin
     * @param end
     * @return
     */
    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);

    /**
     * 导出数据
     * @param response
     */
    void exportData(HttpServletResponse response) throws Exception;


}
