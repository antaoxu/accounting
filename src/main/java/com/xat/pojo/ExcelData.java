package com.xat.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 淡漠
 */
@Data
public class ExcelData {
    private String 公司名称;

    @ExcelProperty("2020期初余额")
    @NumberFormat("0.00_ ")
    private BigDecimal _2020期初余额;

    @ExcelProperty("2020本期借方")
    @ContentStyle(dataFormat = 2)
    private BigDecimal _2020本期借方;

    @ExcelProperty("2020本期贷方")
    @NumberFormat("0.00_ ")
    private BigDecimal _2020本期贷方;

    @ExcelProperty("2021期初余额")
    @NumberFormat("0.00_ ")
    private BigDecimal _2021期初余额;

    @ExcelProperty("2021本期借方")
    @NumberFormat("0.00_ ")
    private BigDecimal _2021本期借方;

    @ExcelProperty("2021本期贷方")
    @NumberFormat("0.00_ ")
    private BigDecimal _2021本期贷方;

    @ExcelProperty("2022期初余额")
    @NumberFormat("0.00_ ")
    private BigDecimal _2022期初余额;

    @ExcelProperty("2022本期借方")
    @NumberFormat("0.00_ ")
    private BigDecimal _2022本期借方;

    @ExcelProperty("2022本期贷方")
    @NumberFormat("0.00_ ")
    private BigDecimal _2022本期贷方;

    @ExcelProperty("2022期末余额")
    @NumberFormat("0.00_ ")
    private BigDecimal _2022期末余额;

    @ExcelProperty("2023本期借方")
    @NumberFormat("0.00_ ")
    private BigDecimal _2023本期借方;

    @ExcelProperty("2023本期贷方")
    @NumberFormat("0.00_ ")
    private BigDecimal _2023本期贷方;

    @ExcelProperty("2023期末余额")
    @NumberFormat("0.00_ ")
    private BigDecimal _2023期末余额;

    @ExcelProperty("1年以内")
    @NumberFormat("0.00_ ")
    private BigDecimal _1年以内;

    @ExcelProperty("1-2年")
    @NumberFormat("0.00_ ")
    private BigDecimal _1_2年;

    @ExcelProperty("2-3年")
    @NumberFormat("0.00_ ")
    private BigDecimal _2_3年;

    @ExcelProperty("3年以上")
    @NumberFormat("0.00_ ")
    private BigDecimal _3年以上;




}
