package com.yunussen.debtpaymentws.service;

import com.yunussen.debtpaymentws.entity.DebtEntity;
import com.yunussen.debtpaymentws.entity.DebtType;
import com.yunussen.debtpaymentws.repository.DebtRepository;
import com.yunussen.debtpaymentws.shared.dto.DebtDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DebtServiceImpl implements DebtService{

    @Autowired
    private DebtRepository debtRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DebtDto save(DebtDto debt) {
        debt.setDebtType(DebtType.NORMAL);
        return modelMapper.map(debtRepo.save(modelMapper.map(debt,DebtEntity.class)),DebtDto.class);
    }

    @Override
    public List<DebtDto> getDebtByBetwenDates(@NotNull Date date1,@NotNull  Date date2) {
        List<DebtDto> returnValue=new ArrayList<>();
        debtRepo.getDebtEntitiesByBetwenDates(date1,date2).forEach(debt->{
            returnValue.add(modelMapper.map(debt,DebtDto.class));
        });
        return returnValue;
    }

    @Override
    public List<DebtDto> getDebtEntitiesByUserId(Long userId) {
        List<DebtDto> returnValue=new ArrayList<>();
        debtRepo.getDebtEntitiesByUserId(userId).forEach(debt->{
            returnValue.add(modelMapper.map(debt,DebtDto.class));
        });
        return returnValue;
    }

    @Override
    public List<DebtDto> getDebtByOverdue() {
        List<DebtDto> returnValue=new ArrayList<>();
        debtRepo.getDebtEntitiesByOverdue(new Date()).forEach(debt->{
            returnValue.add(modelMapper.map(debt,DebtDto.class));
        });
        return returnValue;
    }

    @Override
    public Double getTotalNormalDebtByUserId(Long userId) {
        return debtRepo.getTotalNormalDebtByUserId(userId);
    }

    @Override
    public Double getTotalGecikmisDebtByUserId(Long userId) {
        return debtRepo.getTotalGecikmisDebtByUserId(userId);
    }

    @Override
    public Double getTotalDebtByOverdueAndUserId(Long userId) {
        return debtRepo.getTotalDebtByOverdueAndUserId(new Date(),userId);
    }
}
