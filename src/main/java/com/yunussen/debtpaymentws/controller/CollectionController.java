package com.yunussen.debtpaymentws.controller;

import com.yunussen.debtpaymentws.service.CollectionService;
import com.yunussen.debtpaymentws.shared.dto.CollectionDto;
import com.yunussen.debtpaymentws.shared.dto.DebtDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//tahsilat
@RestController
@RequestMapping("/api/collection")

public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @Operation(summary = "creat collection by bedt id")
    @PostMapping("/{debtId}")
    public ResponseEntity<CollectionDto> makePayment(@PathVariable Long debtId){
        return ResponseEntity.ok(collectionService.makePayment(debtId));
    }

    @Operation(summary = "get collections between dates")
    @GetMapping("/{first-date}/{second-date}")
    public ResponseEntity<List<CollectionDto>> getCollectionBetwenDate(@PathVariable(value = "first-date")@DateTimeFormat(pattern="yyyy-MM-dd") Date firstDate, @PathVariable(value = "second-date")@DateTimeFormat(pattern="yyyy-MM-dd") Date secondDate){
        return ResponseEntity.ok(collectionService.getCollectionByBetwenDates(firstDate,secondDate));
    }

    @Operation(summary = "get collections by user id")
    @GetMapping("/{userId}")
    public ResponseEntity<List<CollectionDto>> getCollectionByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(collectionService.getCollectionByUserId(userId));
    }

    @Operation(summary = "get gecikme zammi by user id")
    @GetMapping("total-gecikme-zammı/{userId}")
    public ResponseEntity<Double> getTotalGecikmeZammiByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(collectionService.getTotalGecikmeZammiByUserId(userId));
    }


}
