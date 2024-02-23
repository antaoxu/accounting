package com.xat.controller;

import com.xat.pojo.ExcelData;
import com.xat.service.IExcelProcessService;
import com.xat.service.IShouldPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 淡漠
 */
@Slf4j
@RestController
public class CalculateController {
    @Autowired
    private IExcelProcessService excelProcessService;
    @Autowired
    private IShouldPayService shouldPayService;
    // /root/download/account/
    public static final String inputFile = "/root/account/input/";
    public static final String midOutputFile = "/root/account/mid/mid.xlsx";
    public static final String outputFile = "/root/account/result/宝贝的最终结果.xlsx";
    // 读取原始 Excel 文件

    @PostMapping("/payCalculate")
    public String payCalculate(@RequestBody MultipartFile file) {
        // 输入的 Excel 文件路径
        String filePath = inputFile+"/"+ file.getOriginalFilename();
        log.info("读取文件的路径为：{}",filePath);
        List<ExcelData> dataList = excelProcessService.readExcel(filePath);

        log.info("文件读取结束，开始转换文件");
        List < ExcelData > inputDataList = shouldPayService.negativeToPositive(dataList);
        log.info("文件正负数转换结束，开始计算账龄");
        // 将转换结果写入到中间的 Excel 文件
        excelProcessService.writeExcel(midOutputFile, inputDataList);
        // 读取 Excel 文件
        log.info("读取正负数转换后的文件开始");
        List<ExcelData> midDataList = excelProcessService.readExcel(midOutputFile);
        log.info("读取正负数转换后的文件结束");
        // 计算每一行的结果
        log.info("计算账龄开始");
        List<ExcelData> resultDataList = shouldPayService.calculatePayData(midDataList);
        log.info("计算账龄结束");
        // 将计算结果写入到最终结果文件
        excelProcessService.writeExcel(outputFile, resultDataList);
        return "文件解析成功啦，棒棒哒！";
    }

}




