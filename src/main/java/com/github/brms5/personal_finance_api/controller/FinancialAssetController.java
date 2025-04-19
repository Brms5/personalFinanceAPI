package com.github.brms5.personal_finance_api.controller;

import com.github.brms5.personal_finance_api.controller.request.FinancialAssetCreateRequest;
import com.github.brms5.personal_finance_api.controller.request.FinancialAssetUpdateRequest;
import com.github.brms5.personal_finance_api.controller.response.FinancialAssetResponse;
import com.github.brms5.personal_finance_api.dto.FinancialAssetDto;
import com.github.brms5.personal_finance_api.mapper.FinancialAssetDtoMapper;
import com.github.brms5.personal_finance_api.mapper.FinancialAssetResponseMapper;
import com.github.brms5.personal_finance_api.service.FinancialAssetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/financial-assets")
@RequiredArgsConstructor
public class FinancialAssetController {

    private final FinancialAssetService financialAssetService;

    @PostMapping("/createNewFinancialAsset")
    public ResponseEntity<FinancialAssetResponse> createFinancialAsset(@RequestBody @Valid FinancialAssetCreateRequest financialAssetCreateRequest) {
        FinancialAssetDto financialAssetDto = FinancialAssetDtoMapper.mapCreateRequestToDto(financialAssetCreateRequest);
        FinancialAssetDto response = financialAssetService.addFinancialAsset(financialAssetDto);

        return ResponseEntity.ok(FinancialAssetResponseMapper.mapToResponse(response));
    }

    @GetMapping("/account/{accountId}/reference-month/{referenceMonth}")
    public ResponseEntity<List<FinancialAssetResponse>> getAllFinancialAssetsByAccountIdAndReferenceMonth(
            @PathVariable String accountId, @PathVariable Month referenceMonth) {
        var financialAssetDto = FinancialAssetDto.builder()
                .accountId(accountId)
                .referenceMonth(referenceMonth)
                .build();

        List<FinancialAssetDto> financialAssets = financialAssetService.getAllFinancialAssetsByAccountIdAndReferenceMonth(financialAssetDto);
        List<FinancialAssetResponse> response = financialAssets.stream()
                .map(FinancialAssetResponseMapper::mapToResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateFinancialAsset")
    public ResponseEntity<FinancialAssetResponse> updateFinancialAsset(@RequestBody @Valid FinancialAssetUpdateRequest financialAssetUpdateRequest) {
        FinancialAssetDto updatedFinancialAsset = financialAssetService.updateFinancialAsset(
                FinancialAssetDtoMapper.mapUpdateRequestToDto(financialAssetUpdateRequest));
        return ResponseEntity.ok(FinancialAssetResponseMapper.mapToResponse(updatedFinancialAsset));
    }
}