package com.github.brms5.personal_finance_api.controller;

import com.github.brms5.personal_finance_api.controller.request.FinancialLiabilityResquest;
import com.github.brms5.personal_finance_api.controller.response.FinancialLiabilityResponse;
import com.github.brms5.personal_finance_api.dto.FinancialLiabilityDto;
import com.github.brms5.personal_finance_api.mapper.FinancialLiabilityDtoMapper;
import com.github.brms5.personal_finance_api.mapper.FinancialLiabilityResponseMapper;
import com.github.brms5.personal_finance_api.service.FinancialLiabilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/financial-liabilities")
@RequiredArgsConstructor
public class FinancialLiabilityController {

    private final FinancialLiabilityService financialLiabilityService;

    @PostMapping("/financial-liability")
    public ResponseEntity<FinancialLiabilityResponse> addFinancialLiability(@RequestBody @Valid FinancialLiabilityResquest financialLiabilityResquest) {
        FinancialLiabilityDto financialLiabilityDto = FinancialLiabilityDtoMapper.mapToDto(financialLiabilityResquest);
        financialLiabilityService.addFinancialLiability(financialLiabilityDto);

        return ResponseEntity.ok(FinancialLiabilityResponseMapper.mapToResponse(financialLiabilityDto));
    }
}
