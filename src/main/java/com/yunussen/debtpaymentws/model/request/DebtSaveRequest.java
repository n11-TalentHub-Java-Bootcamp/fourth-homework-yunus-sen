package com.yunussen.debtpaymentws.model.request;

import com.yunussen.debtpaymentws.entity.DebtType;
import lombok.Data;

import java.util.Date;

@Data
public class DebtSaveRequest {
    private Double debtValue;
    private Date vadeDate;
    private Long userId;
}
