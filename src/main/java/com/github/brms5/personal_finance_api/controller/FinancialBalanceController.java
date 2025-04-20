package com.github.brms5.personal_finance_api.controller;

import com.github.brms5.personal_finance_api.controller.response.FinancialBalanceResponse;
import com.github.brms5.personal_finance_api.dto.FinancialBalanceDto;
import com.github.brms5.personal_finance_api.mapper.FinancialBalanceResponseMapper;
import com.github.brms5.personal_finance_api.service.FinancialBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;

@RestController
@RequestMapping("/api/v1/financial-balances")
@RequiredArgsConstructor
public class FinancialBalanceController {

    private final FinancialBalanceService financialBalanceService;

    @GetMapping("/account/{accountId}/reference-month/{referenceMonth}")
    public ResponseEntity<FinancialBalanceResponse> getFinancialBalanceByAccountIdAndReferenceMonth(
            @PathVariable String accountId, @PathVariable Month referenceMonth) {
        FinancialBalanceDto financialBalanceDto = financialBalanceService.getFinancialBalanceByAccountIdAndReferenceMonth(accountId, referenceMonth);
        return ResponseEntity.ok(FinancialBalanceResponseMapper.mapDtoToResponse(financialBalanceDto));
    }
}
