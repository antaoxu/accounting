package com.xat.service;

import com.xat.pojo.ExcelData;

import java.util.List;

/**
 * @author 淡漠
 */
public interface IExcelProcessService {
    /**
     * @param inputFile
     * @return
     * 读取ecxel
     */
    List<ExcelData> readExcel(String inputFile);

    void writeExcel(String outputFile, List<ExcelData> resultDataList);
}
