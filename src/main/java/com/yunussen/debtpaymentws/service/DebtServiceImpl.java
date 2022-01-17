package com.yunussen.debtpaymentws.service;

import com.yunussen.debtpaymentws.repository.DebtRepository;
import com.yunussen.debtpaymentws.shared.dto.DebtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DebtServiceImpl implements DebtService{

    @Autowired
    private DebtRepository debtRepo;

    @Override
    public DebtDto save(DebtDto debt) {
        return null;
    }
}
