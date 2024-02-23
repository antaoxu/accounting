package com.xat.pojo;

import com.alibaba.excel.annotation.write.style.ContentStyle;
import lombok.Data;


/**
 * @author 淡漠
 */
@Data
public class OutExcelData {
    private String 公司名称;
    @ContentStyle(dataFormat = 2)
    private String _2020期初余额;
    @ContentStyle(dataFormat = 2)
    private String _2020本期借方;
    @ContentStyle (dataFormat = 2)
    private String _2020本期贷方;
    @ContentStyle (dataFormat = 2)
    private String _2021期初余额;
    @ContentStyle (dataFormat = 2)
    private String _2021本期借方;
    @ContentStyle (dataFormat = 2)
    private String _2021本期贷方;
    @ContentStyle (dataFormat = 2)
    private String _2022期初余额;
    @ContentStyle (dataFormat = 2)
    private String _2022本期借方;
    @ContentStyle (dataFormat = 2)
    private String _2022本期贷方;
    @ContentStyle (dataFormat = 2)
    private String _2022期末余额;
    @ContentStyle (dataFormat = 2)
    private String _2023本期借方;
    @ContentStyle (dataFormat = 2)
    private String _2023本期贷方;
    @ContentStyle (dataFormat = 2)
    private String _2023期末余额;
    @ContentStyle (dataFormat = 2)
    private String _1年以内;
    @ContentStyle (dataFormat = 2)
    private String _1_2年;
    @ContentStyle (dataFormat = 2)
    private String _2_3年;
    @ContentStyle (dataFormat = 2)
    private String _3年以上;
}
