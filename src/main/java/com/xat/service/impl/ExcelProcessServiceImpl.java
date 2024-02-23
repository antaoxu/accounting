package com.xat.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.xat.pojo.ExcelData;
import com.xat.service.IExcelProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 淡漠
 */
@Service
@Slf4j
public class ExcelProcessServiceImpl implements IExcelProcessService {

    @Override
    public List<ExcelData> readExcel(String inputFile) {
        List<ExcelData> dataList = new ArrayList<>();
        try {

            EasyExcel.read(inputFile, ExcelData.class, new AnalysisEventListener<ExcelData>() {
                @Override
                public void invoke(ExcelData data, AnalysisContext context) {
                    dataList.add(data);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext context) {
                    // 数据读取完成后的操作
                }
            }).excelType(ExcelTypeEnum.XLSX).sheet().doRead();
        } catch (Exception e) {
            log.error("读取excel文件异常，异常信息：" + e);
        }
        return dataList;
    }

    @Override
    public void writeExcel(String outputFile, List<ExcelData> resultDataList) {
        EasyExcel.write(outputFile, ExcelData.class)
                .registerWriteHandler(getCellStyleStrategy()) // 设置单元格样式
                .sheet().doWrite(resultDataList);
    }

    /**
     * 这里可以自定义单元格样式，比如设置字体、背景色等
     * 这里使用默认样式
     *
     * @return
     */
    private static WriteCellStyle getCellStyle() {
        WriteCellStyle cellStyle = new WriteCellStyle();
        return cellStyle;
    }

    /**
     * 设置单元格样式策略
     */
    private static HorizontalCellStyleStrategy getCellStyleStrategy() {
        WriteCellStyle cellStyle = getCellStyle();
        HorizontalCellStyleStrategy strategy = new HorizontalCellStyleStrategy(cellStyle, cellStyle);
        return strategy;
    }
}
