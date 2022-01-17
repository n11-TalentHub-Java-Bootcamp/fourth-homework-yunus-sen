package com.yunussen.debtpaymentws.shared.dto;

import com.yunussen.debtpaymentws.entity.DebtType;
import lombok.Data;
import java.util.Date;

@Data
public class DebtDto {
    private Long id;
    private Double debtValue;
    private Date vadeDate;
    private DebtType debtType;
    private Long userId;
    private Long parentDebtId;
}
