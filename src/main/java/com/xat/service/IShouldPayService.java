package com.xat.service;

import com.xat.pojo.ExcelData;

import java.util.List;

/**
 * @author 淡漠
 */
public interface IShouldPayService {


    /**
     * @param dataList
     * @return
     */
    List<ExcelData> calculatePayData(List<ExcelData> dataList);

    /**
     * @param dataList
     * @return
     */
    List<ExcelData> negativeToPositive(List<ExcelData> dataList);
}
