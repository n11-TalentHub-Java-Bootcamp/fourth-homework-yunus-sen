package com.yunussen.debtpaymentws.service;

import com.yunussen.debtpaymentws.shared.dto.DebtDto;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

@Validated
public interface DebtService {

    DebtDto save (DebtDto debt);
    List<DebtDto> getDebtByBetwenDates(Date date1, Date date2);
    List<DebtDto> getDebtEntitiesByUserId(Long userId);
    List<DebtDto> getDebtByOverdue();
}
