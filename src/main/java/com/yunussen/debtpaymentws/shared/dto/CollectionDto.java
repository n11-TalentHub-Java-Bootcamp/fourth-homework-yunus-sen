package com.yunussen.debtpaymentws.shared.dto;

import lombok.Data;

@Data
public class CollectionDto {
    private Long id;
    private Double totalDebt;
    private Long userId;
    private Long debtId;
}
