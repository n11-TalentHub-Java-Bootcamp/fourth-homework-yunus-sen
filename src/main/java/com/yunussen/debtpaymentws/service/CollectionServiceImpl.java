package com.yunussen.debtpaymentws.service;

import com.yunussen.debtpaymentws.entity.CollectionEntity;
import com.yunussen.debtpaymentws.entity.DebtEntity;
import com.yunussen.debtpaymentws.entity.DebtType;
import com.yunussen.debtpaymentws.entity.DefaultInterest;
import com.yunussen.debtpaymentws.repository.CollectionRepository;
import com.yunussen.debtpaymentws.repository.DebtRepository;
import com.yunussen.debtpaymentws.shared.dto.CollectionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionRepository collectionRepo;
    @Autowired
    private DebtRepository debtRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CollectionDto makePayment(Long debtId) {
        DebtEntity debt = debtRepo.findById(debtId).orElseThrow(IllegalArgumentException::new);
        DebtEntity debtOver=new DebtEntity();
        CollectionEntity colectionEntity=new CollectionEntity();
        //vadesi gecmişse gecikme zammı uygulayacagım. ve dbye yeni debt kaytı oluşturacagım.
        if (new Date().after(debt.getVadeDate())){
            Double debtValue=0.0;
            debtOver.setDebtType(DebtType.GECIKME_ZAMMI);
            debtOver.setParentDebtId(debt.getId());
            debtOver.setUserId(debt.getUserId());
            debtOver.setVadeDate(null);
            if(DefaultInterest.DATE.after(debt.getVadeDate())){
                //1.5
                debtValue=debt.getDebtValue()*DefaultInterest.PREVIOS_RATIO;
            }else{
                //2.0
                debtValue=debt.getDebtValue()*DefaultInterest.AFTER_RATIO;
            }
            if(debtValue<1.0){
                debtValue=1.0;
            }
            debtOver.setDebtValue(debtValue);
           debtOver=debtRepo.save(debtOver);
        }

        colectionEntity.setUserId(debt.getUserId());
        colectionEntity.setTotalDebt(debtOver.getDebtValue()+debt.getDebtValue());
        colectionEntity.setDebtId(debt.getId());

        //ana borcu sıfırladım ve gecikme faizi tablosunu ana tabloya bagladım.
        debt.setDebtValue(0.0);
        debt.setParentDebtId(debtOver.getId());
        debtRepo.save(debt);
        return modelMapper.map(collectionRepo.save(colectionEntity),CollectionDto.class);
    }

    @Override
    public List<CollectionDto> getCollectionByBetwenDates(Date firstDate, Date secondDate) {
        List<CollectionDto>returnValue=new ArrayList<>();
        collectionRepo.getCollectionByBetwenDates(firstDate,secondDate).forEach(item->{
           returnValue.add(modelMapper.map(item,CollectionDto.class));
        });
        return returnValue;
    }

    @Override
    public List<CollectionDto> getCollectionByUserId(Long userId) {
        List<CollectionDto>returnValue=new ArrayList<>();
        collectionRepo.findByUserId(userId).forEach(item->{
            returnValue.add(modelMapper.map(item,CollectionDto.class));
        });
        return returnValue;
    }

    @Override
    public Double getTotalGecikmeZammiByUserId(Long userId) {
        return debtRepo.getTotalGecikmisDebtByUserId(userId);
    }
}
