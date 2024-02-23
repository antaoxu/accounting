package com.xat.service.impl;

import com.xat.pojo.AccountingBalance;
import com.xat.pojo.ExcelData;
import com.xat.service.IShouldPayService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 淡漠
 */
@Service
public class IShouldPayServiceImpl implements IShouldPayService {


    @Override
    public List<ExcelData> calculatePayData(List<ExcelData> dataList) {
        List<ExcelData> resultDataList = new ArrayList<>();
        for (ExcelData data : dataList) {
            // 计算每一行的结果
            ExcelData excelData = calculate(data);
            resultDataList.add(excelData);
        }
        return resultDataList;
    }

    @Override
    public List<ExcelData> negativeToPositive(List<ExcelData> dataList) {
        List<ExcelData> resultDataList = new ArrayList<>();
        for (ExcelData data : dataList) {
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
            BigDecimal _2020本期借方 = data.get_2020本期借方();
            BigDecimal _2020本期贷方 = data.get_2020本期贷方();
            BigDecimal _2021本期借方 = data.get_2021本期借方();
            BigDecimal _2021本期贷方 = data.get_2021本期贷方();
            BigDecimal _2022本期借方 = data.get_2022本期借方();
            BigDecimal _2022本期贷方 = data.get_2022本期贷方();
            BigDecimal _2023本期借方 = data.get_2023本期借方();
            BigDecimal _2023本期贷方 = data.get_2023本期贷方();
            if (_2020本期借方.compareTo(new BigDecimal(0)) < 0 && _2020本期贷方.compareTo(new BigDecimal(0)) >= 0) {
                _2020本期贷方 = _2020本期贷方.subtract(_2020本期借方);
                _2020本期借方 = new BigDecimal(0);
            }
            if (_2020本期贷方.compareTo(new BigDecimal(0)) < 0 && _2020本期借方.compareTo(new BigDecimal(0)) >= 0) {
                _2020本期借方 = _2020本期借方.subtract(_2020本期贷方);
                _2020本期贷方 = new BigDecimal(0);
            }
            if (_2020本期贷方.compareTo(new BigDecimal(0)) < 0 && _2020本期借方.compareTo(new BigDecimal(0)) < 0) {
                _2020本期借方 = _2020本期贷方.abs();
                _2020本期贷方 = data.get_2020本期借方().abs();
            }

            if (_2021本期借方.compareTo(new BigDecimal(0)) < 0 && _2021本期贷方.compareTo(new BigDecimal(0)) >= 0) {
                _2021本期贷方 = _2021本期贷方.subtract(_2021本期借方);
                _2021本期借方 = new BigDecimal(0);
            }
            if (_2021本期贷方.compareTo(new BigDecimal(0)) < 0 && _2021本期借方.compareTo(new BigDecimal(0)) >= 0) {
                _2021本期借方 = _2021本期借方.subtract(_2021本期贷方);
                _2021本期贷方 = new BigDecimal(0);
            }
            if (_2021本期贷方.compareTo(new BigDecimal(0)) < 0 && _2021本期借方.compareTo(new BigDecimal(0)) < 0) {
                _2021本期借方 = _2021本期贷方.abs();
                _2021本期贷方 = data.get_2021本期借方().abs();
            }
            if (_2022本期借方.compareTo(new BigDecimal(0)) < 0 && _2022本期贷方.compareTo(new BigDecimal(0)) >= 0) {
                _2022本期贷方 = _2022本期贷方.subtract(_2022本期借方);
                _2022本期借方 = new BigDecimal(0);
            }
            if (_2022本期贷方.compareTo(new BigDecimal(0)) < 0 && _2022本期借方.compareTo(new BigDecimal(0)) >= 0) {
                _2022本期借方 = _2022本期借方.subtract(_2022本期贷方);
                _2022本期贷方 = new BigDecimal(0);
            }
            if (_2022本期贷方.compareTo(new BigDecimal(0)) < 0 && _2022本期借方.compareTo(new BigDecimal(0)) < 0) {
                _2022本期借方 = _2022本期贷方.abs();
                _2022本期贷方 = data.get_2022本期借方().abs();
            }
            if (_2023本期借方.compareTo(new BigDecimal(0)) < 0 && _2023本期贷方.compareTo(new BigDecimal(0)) >= 0) {
                _2023本期贷方 = _2023本期贷方.subtract(_2023本期借方);
                _2023本期借方 = new BigDecimal(0);
            }
            if (_2023本期贷方.compareTo(new BigDecimal(0)) < 0 && _2023本期借方.compareTo(new BigDecimal(0)) >= 0) {
                _2023本期借方 = _2023本期借方.subtract(_2023本期贷方);
                _2023本期贷方 = new BigDecimal(0);
            }
            if (_2023本期贷方.compareTo(new BigDecimal(0)) < 0 && _2023本期借方.compareTo(new BigDecimal(0)) < 0) {
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


        if (data.get_2021本期借方().compareTo(data.get_2021期初余额()) < 0) {
            _2022.setOneToTwoYear(_2021.getLessOneYear().subtract(data.get_2021本期借方()));
            _2022.setLessOneYear(data.get_2021本期贷方());
            _2022.setTwoToThreeYear(new BigDecimal(0));
            _2022.setMoreThreeYears(new BigDecimal(0));
        } else {
            _2022.setOneToTwoYear(new BigDecimal(0));
            _2022.setLessOneYear(data.get_2021本期贷方().subtract(data.get_2021本期借方().subtract(_2021.getLessOneYear())));
            _2022.setTwoToThreeYear(new BigDecimal(0));
            _2022.setMoreThreeYears(new BigDecimal(0));
        }

        if (data.get_2022本期借方().compareTo(_2022.getOneToTwoYear()) < 0) {
            _2023.setTwoToThreeYear(_2022.getOneToTwoYear().subtract(data.get_2022本期借方()));
            _2023.setOneToTwoYear(_2022.getLessOneYear());
            _2023.setMoreThreeYears(new BigDecimal(0));
            _2023.setLessOneYear(data.get_2022本期贷方());
        } else if (data.get_2022本期借方().compareTo(_2022.getOneToTwoYear()) >= 0 && data.get_2022本期借方().compareTo(_2022.getOneToTwoYear().add(_2022.getLessOneYear())) < 0) {
            _2023.setTwoToThreeYear(new BigDecimal(0));
            _2023.setOneToTwoYear(_2022.getLessOneYear().subtract(data.get_2022本期借方().subtract(_2022.getOneToTwoYear())));
            _2023.setLessOneYear(data.get_2022本期贷方());
            _2023.setMoreThreeYears(new BigDecimal(0));
        } else {
            _2023.setTwoToThreeYear(new BigDecimal(0));
            _2023.setOneToTwoYear(new BigDecimal(0));
            _2023.setLessOneYear(data.get_2022本期贷方().subtract(data.get_2022本期借方().subtract(_2022.getLessOneYear()).subtract(_2022.getOneToTwoYear())));
            _2023.setMoreThreeYears(new BigDecimal(0));
        }

        if (data.get_2023本期借方().compareTo(_2023.getTwoToThreeYear()) < 0) {
            _2024.setMoreThreeYears(_2023.getTwoToThreeYear().subtract(data.get_2023本期借方()));
            _2024.setTwoToThreeYear(_2023.getOneToTwoYear());
            _2024.setOneToTwoYear(_2023.getLessOneYear());
            _2024.setLessOneYear(data.get_2023本期贷方());
        } else if (data.get_2023本期借方().compareTo(_2022.getTwoToThreeYear()) >= 0 &&
                data.get_2023本期借方().compareTo(_2023.getTwoToThreeYear().add(_2023.getOneToTwoYear())) < 0) {
            _2024.setMoreThreeYears(new BigDecimal(0));
            _2024.setTwoToThreeYear(_2023.getOneToTwoYear().subtract(data.get_2023本期借方().subtract(_2023.getTwoToThreeYear())));
            _2024.setOneToTwoYear(_2023.getLessOneYear());
            _2024.setLessOneYear(data.get_2023本期贷方());

        } else if (data.get_2023本期借方().compareTo(_2023.getTwoToThreeYear()) >= 0 &&
                data.get_2023本期借方().compareTo(_2023.getTwoToThreeYear().add(_2023.getOneToTwoYear())) >= 0 &&
                data.get_2023本期借方().compareTo(_2023.getTwoToThreeYear().add(_2023.getOneToTwoYear()).add(_2023.getLessOneYear())) < 0) {
            _2024.setMoreThreeYears(new BigDecimal(0));
            _2024.setTwoToThreeYear(new BigDecimal(0));
            _2024.setOneToTwoYear(_2023.getLessOneYear().subtract(
                    data.get_2023本期借方().subtract(_2023.getOneToTwoYear()).subtract(_2023.getTwoToThreeYear())));
            _2024.setLessOneYear(data.get_2023本期贷方());

        } else {
            _2024.setMoreThreeYears(new BigDecimal(0));
            _2024.setTwoToThreeYear(new BigDecimal(0));
            _2024.setOneToTwoYear(new BigDecimal(0));
            BigDecimal _2024lessOneYear = data.get_2023本期贷方().subtract(data.get_2023本期借方().subtract(_2023.getTwoToThreeYear()).subtract(_2023.getOneToTwoYear()).subtract(_2023.getLessOneYear()));
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
}
