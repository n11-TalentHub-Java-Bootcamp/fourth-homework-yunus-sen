package com.yunussen.debtpaymentws.repository;

import com.yunussen.debtpaymentws.entity.CollectionEntity;
import com.yunussen.debtpaymentws.shared.dto.CollectionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionEntity,Long> {
    @Query("SELECT c FROM CollectionEntity c WHERE c.createdAt BETWEEN :date1 AND :date2")
    Iterable<CollectionEntity>getCollectionByBetwenDates(@Param("date1") Date date1, @Param("date2") Date date2);
    Iterable<CollectionEntity> findByUserId(Long userId);
}
