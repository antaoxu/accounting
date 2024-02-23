package com.xat.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.xat.pojo.AccountingBalance;
import com.xat.pojo.ExcelData;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 淡漠
 */
public class ShouldReceiveProcessor {

    /*public static void main(String[] args) {
        // 输入的 Excel 文件路径
        String inputFile = "D:\\download\\Tim\\origin.xlsx";
        // 中途输出的 Excel 文件路径
        String midOutputFile = "D:\\download\\Tim\\mid-01.xlsx.xlsx";
        // 输出的 Excel 文件路径
        String outputFile = "D:\\download\\Tim\\final.xlsx";
        // 读取原始 Excel 文件
        List<ExcelData> dataList = readExcel(inputFile);

        *//**
         * 负数转正数
         *//*
        List<ExcelData> inputDataList = negativeToPositive(dataList);
        // 将转换结果写入到中间的 Excel 文件
        writeExcel(midOutputFile, inputDataList);
        // 读取 Excel 文件
        List<ExcelData> midDataList = readExcel(midOutputFile);
        // 计算每一行的结果
        List<ExcelData> resultDataList = calculatePayData(midDataList);
        // 将计算结果写入到最终结果文件
        writeExcel(outputFile, resultDataList);
    }
*/
    /**
     * 读取 Excel 文件
     * @param inputFile
     * @return
     */
    private static List<ExcelData> readExcel(String inputFile) {
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
            }).sheet().doRead();
        }catch (Exception e){
            System.out.println("读取excel文件异常，异常信息："+ e);
        }
        return dataList;
    }
    /**
     * @param dataList
     * @param
     * @return
     */
    private static List<ExcelData> calculatePayData(List<ExcelData> dataList) {
        List<ExcelData> resultDataList = new ArrayList<>();
        for (ExcelData data : dataList) {
            // 计算每一行的结果
            ExcelData excelData = calculate(data);
            resultDataList.add(excelData);
        }
        return resultDataList;
    }

    private static ExcelData calculate(ExcelData data) {
        AccountingBalance _2021 = new AccountingBalance();
        AccountingBalance _2022 = new AccountingBalance();
        AccountingBalance _2023 = new AccountingBalance();
        AccountingBalance _2024 = new AccountingBalance();
        if (data.get_2020期初余额() == null) {
            data.set_2020期初余额(new BigDecimal(0));
        }
        if (data.get_2020本期借方() == null) {
            data.set_2020本期借方(new BigDecimal(0));
        }
        if (data.get_2020本期贷方() == null) {
            data.set_2020本期贷方(new BigDecimal(0));
        }
        if (data.get_2021期初余额() == null) {
            data.set_2021期初余额(new BigDecimal(0));
        }
        if (data.get_2021本期借方() == null) {
            data.set_2021本期借方(new BigDecimal(0));
        }
        if (data.get_2021本期贷方() == null) {
            data.set_2021本期贷方(new BigDecimal(0));
        }
        if (data.get_2022期初余额() == null) {
            data.set_2022期初余额(new BigDecimal(0));
        }
        if (data.get_2022本期借方() == null) {
            data.set_2022本期借方(new BigDecimal(0));
        }
        if (data.get_2022本期贷方() == null) {
            data.set_2022本期贷方(new BigDecimal(0));
        }
        if (data.get_2022期末余额() == null) {
            data.set_2022期末余额(new BigDecimal(0));
        }
        if (data.get_2023本期借方() == null) {
            data.set_2023本期借方(new BigDecimal(0));
        }
        if (data.get_2023本期贷方() == null) {
            data.set_2023本期贷方(new BigDecimal(0));
        }
        if (data.get_2023期末余额() == null) {
            data.set_2023期末余额(new BigDecimal(0));
        }


        _2021.setLessOneYear(data.get_2021期初余额());
        _2021.setOneToTwoYear(new BigDecimal(0));
        _2021.setTwoToThreeYear(new BigDecimal(0));
        _2021.setMoreThreeYears(new BigDecimal(0));


        if (data.get_2021本期贷方().compareTo(data.get_2021期初余额()) < 0) {
            _2022.setOneToTwoYear(_2021.getLessOneYear().subtract(data.get_2021本期贷方()));
            _2022.setLessOneYear(data.get_2021本期借方());
            _2022.setTwoToThreeYear(new BigDecimal(0));
            _2022.setMoreThreeYears(new BigDecimal(0));
        } else {
            _2022.setOneToTwoYear(new BigDecimal(0));
            _2022.setLessOneYear(data.get_2021本期借方().subtract(data.get_2021本期贷方().subtract(_2021.getLessOneYear())));
            _2022.setTwoToThreeYear(new BigDecimal(0));
            _2022.setMoreThreeYears(new BigDecimal(0));
        }

        if (data.get_2022本期贷方().compareTo(_2022.getOneToTwoYear()) < 0) {
            _2023.setTwoToThreeYear(_2022.getOneToTwoYear().subtract(data.get_2022本期贷方()));
            _2023.setOneToTwoYear(_2022.getLessOneYear());
            _2023.setMoreThreeYears(new BigDecimal(0));
            _2023.setLessOneYear(data.get_2022本期借方());
        } else if (data.get_2022本期贷方().compareTo(_2022.getOneToTwoYear()) >= 0 && data.get_2022本期贷方().compareTo(_2022.getOneToTwoYear().add(_2022.getLessOneYear())) < 0) {
            _2023.setTwoToThreeYear(new BigDecimal(0));
            _2023.setOneToTwoYear(_2022.getLessOneYear().subtract(data.get_2022本期贷方().subtract(_2022.getOneToTwoYear())));
            _2023.setLessOneYear(data.get_2022本期借方());
            _2023.setMoreThreeYears(new BigDecimal(0));
        } else {
            _2023.setTwoToThreeYear(new BigDecimal(0));
            _2023.setOneToTwoYear(new BigDecimal(0));
            _2023.setLessOneYear(data.get_2022本期借方().subtract(data.get_2022本期贷方().subtract(_2022.getLessOneYear()).subtract(_2022.getOneToTwoYear())));
            _2023.setMoreThreeYears(new BigDecimal(0));
        }
        if (data.get_2023本期贷方().compareTo(_2023.getTwoToThreeYear()) < 0) {
            _2024.setMoreThreeYears(_2023.getTwoToThreeYear().subtract(data.get_2023本期贷方()));
            _2024.setTwoToThreeYear(_2023.getOneToTwoYear());
            _2024.setOneToTwoYear(_2023.getLessOneYear());
            _2024.setLessOneYear(data.get_2023本期借方());
        } else if (data.get_2023本期贷方().compareTo(_2022.getTwoToThreeYear()) >= 0 &&
                data.get_2023本期贷方().compareTo(_2023.getTwoToThreeYear().add(_2023.getOneToTwoYear())) < 0) {
            _2024.setMoreThreeYears(new BigDecimal(0));
            _2024.setTwoToThreeYear(_2023.getOneToTwoYear().subtract(data.get_2023本期贷方().subtract(_2023.getTwoToThreeYear())));
            _2024.setOneToTwoYear(_2023.getLessOneYear());
            _2024.setLessOneYear(data.get_2023本期借方());

        } else if (data.get_2023本期贷方().compareTo(_2023.getTwoToThreeYear()) >= 0 &&
                data.get_2023本期贷方().compareTo(_2023.getTwoToThreeYear().add(_2023.getOneToTwoYear())) >= 0 &&
                data.get_2023本期贷方().compareTo(_2023.getTwoToThreeYear().add(_2023.getOneToTwoYear()).add(_2023.getLessOneYear())) < 0) {
            _2024.setMoreThreeYears(new BigDecimal(0));
            _2024.setTwoToThreeYear(new BigDecimal(0));
            _2024.setOneToTwoYear(_2023.getLessOneYear().subtract(
                    data.get_2023本期贷方().subtract(_2023.getOneToTwoYear()).subtract(_2023.getTwoToThreeYear())));
            _2024.setLessOneYear(data.get_2023本期借方());

        } else {
            _2024.setMoreThreeYears(new BigDecimal(0));
            _2024.setTwoToThreeYear(new BigDecimal(0));
            _2024.setOneToTwoYear(new BigDecimal(0));
            BigDecimal _2024lessOneYear = data.get_2023本期借方().subtract(data.get_2023本期贷方().subtract(_2023.getTwoToThreeYear()).subtract(_2023.getOneToTwoYear()).subtract(_2023.getLessOneYear()));
            _2024.setLessOneYear(_2024lessOneYear);
        }

        // 将计算结果添加到新的数据对象中
        ExcelData resultData = new ExcelData();
        resultData.set公司名称(data.get公司名称());
        resultData.set_2020期初余额(data.get_2020期初余额());
        resultData.set_2020本期借方(data.get_2020本期借方());
        resultData.set_2020本期贷方(data.get_2020本期贷方());
        resultData.set_2021期初余额(data.get_2021期初余额());
        resultData.set_2021本期借方(data.get_2021本期借方());
        resultData.set_2021本期贷方(data.get_2021本期贷方());
        resultData.set_2022期初余额(data.get_2022期初余额());
        resultData.set_2022本期借方(data.get_2022本期借方());
        resultData.set_2022本期贷方(data.get_2022本期贷方());
        resultData.set_2022期末余额(data.get_2022期末余额());
        resultData.set_2023本期借方(data.get_2023本期借方());
        resultData.set_2023本期贷方(data.get_2023本期贷方());
        //double newValue = data.get_2023期末余额().round(new MathContext(11, RoundingMode.HALF_UP)).doubleValue();
        resultData.set_2023期末余额(data.get_2023期末余额());
        resultData.set_1年以内(_2024.getLessOneYear());
        resultData.set_1_2年(_2024.getOneToTwoYear());
        resultData.set_2_3年(_2024.getTwoToThreeYear());
        resultData.set_3年以上(_2024.getMoreThreeYears());
        return resultData;
    }

    private static List<ExcelData> negativeToPositive (List<ExcelData> dataList) {
        List<ExcelData> resultDataList = new ArrayList<>();
        for (ExcelData data : dataList) {
            if (data.get_2020期初余额() == null){data.set_2020期初余额(new BigDecimal(0));}
            if (data.get_2020本期借方() == null){data.set_2020本期借方(new BigDecimal(0));}
            if (data.get_2020本期贷方() == null){data.set_2020本期贷方(new BigDecimal(0));}
            if (data.get_2021期初余额() == null){data.set_2021期初余额(new BigDecimal(0));}
            if (data.get_2021本期借方() == null){data.set_2021本期借方(new BigDecimal(0));}
            if (data.get_2021本期贷方() == null){data.set_2021本期贷方(new BigDecimal(0));}
            if (data.get_2022期初余额() == null){data.set_2022期初余额(new BigDecimal(0));}
            if (data.get_2022本期借方() == null){data.set_2022本期借方(new BigDecimal(0));}
            if (data.get_2022本期贷方() == null){data.set_2022本期贷方(new BigDecimal(0));}
            if (data.get_2022期末余额() == null){data.set_2022期末余额(new BigDecimal(0));}
            if (data.get_2023本期借方() == null){data.set_2023本期借方(new BigDecimal(0));}
            if (data.get_2023本期贷方() == null){data.set_2023本期贷方(new BigDecimal(0));}
            if (data.get_2023期末余额() == null){data.set_2023期末余额(new BigDecimal(0));}
            BigDecimal _2020本期借方  = data.get_2020本期借方();
            BigDecimal _2020本期贷方  = data.get_2020本期贷方();
            BigDecimal _2021本期借方  = data.get_2021本期借方();
            BigDecimal _2021本期贷方  = data.get_2021本期贷方();
            BigDecimal _2022本期借方  = data.get_2022本期借方();
            BigDecimal _2022本期贷方  = data.get_2022本期贷方();
            BigDecimal _2023本期借方  = data.get_2023本期借方();
            BigDecimal _2023本期贷方  = data.get_2023本期贷方();
            if (_2020本期借方.compareTo(new BigDecimal(0))<0 && _2020本期贷方.compareTo(new BigDecimal(0))>=0){
                _2020本期贷方 = _2020本期贷方.subtract(_2020本期借方);
                _2020本期借方 = new BigDecimal(0);
            }
            if (_2020本期贷方.compareTo(new BigDecimal(0))<0 && _2020本期借方.compareTo(new BigDecimal(0))>=0){
                _2020本期借方 = _2020本期借方.subtract(_2020本期贷方);
                _2020本期贷方 = new BigDecimal(0);
            }
            if (_2020本期贷方.compareTo(new BigDecimal(0))<0 && _2020本期借方.compareTo(new BigDecimal(0))<0){
                _2020本期借方 = _2020本期贷方.abs();
                _2020本期贷方 = data.get_2020本期借方().abs();
            }

            if (_2021本期借方.compareTo(new BigDecimal(0))<0 && _2021本期贷方.compareTo(new BigDecimal(0))>=0){
                _2021本期贷方 = _2021本期贷方.subtract(_2021本期借方);
                _2021本期借方 = new BigDecimal(0);
            }
            if (_2021本期贷方.compareTo(new BigDecimal(0))<0 && _2021本期借方.compareTo(new BigDecimal(0))>=0){
                _2021本期借方 = _2021本期借方.subtract(_2021本期贷方);
                _2021本期贷方 = new BigDecimal(0);
            }
            if (_2021本期贷方.compareTo(new BigDecimal(0))<0 && _2021本期借方.compareTo(new BigDecimal(0))<0){
                _2021本期借方 = _2021本期贷方.abs();
                _2021本期贷方 = data.get_2021本期借方().abs();
            }
            if (_2022本期借方.compareTo(new BigDecimal(0))<0 && _2022本期贷方.compareTo(new BigDecimal(0))>=0){
                _2022本期贷方 = _2022本期贷方.subtract(_2022本期借方);
                _2022本期借方 = new BigDecimal(0);
            }
            if (_2022本期贷方.compareTo(new BigDecimal(0))<0 && _2022本期借方.compareTo(new BigDecimal(0))>=0){
                _2022本期借方 = _2022本期借方.subtract(_2022本期贷方);
                _2022本期贷方 = new BigDecimal(0);
            }
            if (_2022本期贷方.compareTo(new BigDecimal(0))<0 && _2022本期借方.compareTo(new BigDecimal(0))<0){
                _2022本期借方 = _2022本期贷方.abs();
                _2022本期贷方 = data.get_2022本期借方().abs();
            }
            if (_2023本期借方.compareTo(new BigDecimal(0))<0 && _2023本期贷方.compareTo(new BigDecimal(0))>=0){
                _2023本期贷方 = _2023本期贷方.subtract(_2023本期借方);
                _2023本期借方 = new BigDecimal(0);
            }
            if (_2023本期贷方.compareTo(new BigDecimal(0))<0 && _2023本期借方.compareTo(new BigDecimal(0))>=0){
                _2023本期借方 = _2023本期借方.subtract(_2023本期贷方);
                _2023本期贷方 = new BigDecimal(0);
            }
            if (_2023本期贷方.compareTo(new BigDecimal(0))<0 && _2023本期借方.compareTo(new BigDecimal(0))<0){
                _2023本期借方 = _2023本期贷方.abs();
                _2023本期贷方 = data.get_2023本期借方().abs();
            }
            ExcelData resultData = new ExcelData();
            resultData.set公司名称(data.get公司名称());
            resultData.set_2020期初余额(data.get_2020期初余额());
            resultData.set_2020本期借方(_2020本期借方);
            resultData.set_2020本期贷方(_2020本期贷方);
            resultData.set_2021期初余额(data.get_2021期初余额());
            resultData.set_2021本期借方(_2021本期借方);
            resultData.set_2021本期贷方(_2021本期贷方);
            resultData.set_2022期初余额(data.get_2022期初余额());
            resultData.set_2022本期借方(_2022本期借方);
            resultData.set_2022本期贷方(_2022本期贷方);
            resultData.set_2022期末余额(data.get_2022期末余额());
            resultData.set_2023本期借方(_2023本期借方);
            resultData.set_2023本期贷方(_2023本期贷方);
            resultData.set_2023期末余额(data.get_2023期末余额());
            resultData.set_1年以内(new BigDecimal(0));
            resultData.set_1_2年(new BigDecimal(0));
            resultData.set_2_3年(new BigDecimal(0));
            resultData.set_3年以上(new BigDecimal(0));
            resultDataList.add(resultData);
        }
        return resultDataList;
    }

    /**
     * @param outputFile
     * @param resultDataList
     * 将计算结果写入到原来的 Excel 文件
     */
    private static void writeExcel(String outputFile, List<ExcelData> resultDataList) {
        EasyExcel.write(outputFile, ExcelData.class)
                .registerWriteHandler(getCellStyleStrategy()) // 设置单元格样式
                .sheet().doWrite(resultDataList);
    }

    /**
     * 这里可以自定义单元格样式，比如设置字体、背景色等
     * 这里使用默认样式
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

