package com.yunussen.debtpaymentws.controller;

import com.yunussen.debtpaymentws.model.request.DebtSaveRequest;
import com.yunussen.debtpaymentws.service.DebtService;
import com.yunussen.debtpaymentws.shared.dto.DebtDto;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/debts")
public class DebtController {

    @Autowired
    private DebtService debtService;
    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary = "create debt for request model")
    @PostMapping("/")
    public ResponseEntity<DebtSaveRequest> save(@RequestBody @Validated DebtSaveRequest debt){
        return ResponseEntity.ok(modelMapper.map(debtService.save(modelMapper.map(debt,DebtDto.class)),DebtSaveRequest.class));
    }

    @Operation(summary = "get debts between dates")
    @GetMapping("/{first-date}/{second-date}")
    public ResponseEntity<List<DebtDto>> getDebtBetwenDate(@PathVariable(value = "first-date")@DateTimeFormat(pattern="yyyy-MM-dd") Date firstDate, @PathVariable(value = "second-date")@DateTimeFormat(pattern="yyyy-MM-dd") Date secondDate){
        return ResponseEntity.ok(debtService.getDebtByBetwenDates(firstDate,secondDate));
    }

    @Operation(summary = "get debts by user id")
    @GetMapping("/{userId}")
    public ResponseEntity<List<DebtDto>> getDebtByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(debtService.getDebtEntitiesByUserId(userId));
    }

    //vadesi gecmiş borçlar
    @Operation(summary = "get overdue debts  by user id")
    @GetMapping("/overdue-debt")
    public ResponseEntity<List<DebtDto>> getDebtByUserId(){
        return ResponseEntity.ok(debtService.getDebtByOverdue());
    }

    @Operation(summary = "get normal borc debts bt user id")
    @GetMapping("normal-borc/{userId}")
    public ResponseEntity<Double> getTotalNormalDebtByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(debtService.getTotalNormalDebtByUserId(userId));
    }

    @Operation(summary = "get total overdue debts by user id")
    @GetMapping("/overdue-debt-total/{userId}")
    public ResponseEntity<Double> getTotalOverdueDebtByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(debtService.getTotalDebtByOverdueAndUserId(userId));
    }

    @GetMapping("gecikmis-borc/{userId}")
    public ResponseEntity<Double> getTotalGecikmisDebtByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(debtService.getTotalGecikmisDebtByUserId(userId));
    }


}
