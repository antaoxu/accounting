package com.xat.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 淡漠
 */
@Data
public class AccountingBalance {
    private BigDecimal lessOneYear;
    private BigDecimal oneToTwoYear;
    private BigDecimal twoToThreeYear;
    private BigDecimal moreThreeYears;

}
