package com.yunussen.debtpaymentws.service;

import com.yunussen.debtpaymentws.shared.dto.CollectionDto;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

@Validated
public interface CollectionService {
    CollectionDto makePayment(Long debtId);
    List<CollectionDto>getCollectionByBetwenDates(Date firstDate,Date secondDate);
    List<CollectionDto>getCollectionByUserId(Long userId);
    Double getTotalGecikmeZammiByUserId(Long userId);
}
