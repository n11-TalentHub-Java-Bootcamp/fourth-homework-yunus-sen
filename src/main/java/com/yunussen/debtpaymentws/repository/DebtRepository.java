package com.yunussen.debtpaymentws.repository;

import com.yunussen.debtpaymentws.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.util.Date;

@Repository
public interface DebtRepository extends JpaRepository<DebtEntity,Long> {

    @Query("SELECT d FROM DebtEntity d WHERE d.vadeDate BETWEEN :date1 AND :date2")
    Iterable<DebtEntity> getDebtEntitiesByBetwenDates(@Param("date1") Date date1,@Param("date2") Date date2);

    @Query("SELECT d FROM DebtEntity d WHERE d.userId=:userId AND d.debtValue > 0")
    Iterable<DebtEntity> getDebtEntitiesByUserId(Long userId);

    @Query("SELECT d FROM DebtEntity d WHERE d.vadeDate < :currentDate")
    Iterable<DebtEntity> getDebtEntitiesByOverdue(@Param("currentDate") Date currentDate);
}
