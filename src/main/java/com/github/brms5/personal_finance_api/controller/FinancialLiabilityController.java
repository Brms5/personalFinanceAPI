package com.github.brms5.personal_finance_api.controller;

import com.github.brms5.personal_finance_api.controller.request.FinancialLiabilityCreateRequest;
import com.github.brms5.personal_finance_api.controller.request.FinancialLiabilityUpdateRequest;
import com.github.brms5.personal_finance_api.controller.response.FinancialLiabilityResponse;
import com.github.brms5.personal_finance_api.dto.FinancialLiabilityDto;
import com.github.brms5.personal_finance_api.mapper.FinancialLiabilityDtoMapper;
import com.github.brms5.personal_finance_api.mapper.FinancialLiabilityResponseMapper;
import com.github.brms5.personal_finance_api.service.FinancialLiabilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/financial-liabilities")
@RequiredArgsConstructor
public class FinancialLiabilityController {

    private final FinancialLiabilityService financialLiabilityService;

    @PostMapping("/createNewFinancialLiability")
    public ResponseEntity<FinancialLiabilityResponse> createFinancialLiability(@RequestBody @Valid FinancialLiabilityCreateRequest financialLiabilityCreateRequest) {
        FinancialLiabilityDto financialLiabilityDto = FinancialLiabilityDtoMapper.mapCreateRequestToDto(financialLiabilityCreateRequest);
        FinancialLiabilityDto response = financialLiabilityService.addFinancialLiability(financialLiabilityDto);

        return ResponseEntity.ok(FinancialLiabilityResponseMapper.mapToResponse(response));
    }

    @GetMapping("/account/{accountId}/reference-month/{referenceMonth}")
    public ResponseEntity<List<FinancialLiabilityResponse>> getAllFinancialLiabilitiesByAccountIdAndReferenceMonth(
            @PathVariable String accountId, @PathVariable Month referenceMonth) {
        var financialLiabilityDto = FinancialLiabilityDto.builder()
                .accountId(accountId)
                .referenceMonth(referenceMonth)
                .build();

        List<FinancialLiabilityDto> financialLiabilities = financialLiabilityService.getAllFinanceLiabilityByAccountIdAndReferenceMonth(financialLiabilityDto);
        List<FinancialLiabilityResponse> response = financialLiabilities.stream()
                .map(FinancialLiabilityResponseMapper::mapToResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateFinancialLiability")
    public ResponseEntity<FinancialLiabilityResponse> updateFinancialLiability(@RequestBody @Valid FinancialLiabilityUpdateRequest financialLiabilityUpdateRequest) {
        FinancialLiabilityDto updatedFinancialLiability = financialLiabilityService.updateFinancialLiability(
                FinancialLiabilityDtoMapper.mapUpdateRequestToDto(financialLiabilityUpdateRequest));
        return ResponseEntity.ok(FinancialLiabilityResponseMapper.mapToResponse(updatedFinancialLiability));
    }
}