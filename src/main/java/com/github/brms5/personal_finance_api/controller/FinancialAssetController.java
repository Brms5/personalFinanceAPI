package com.github.brms5.personal_finance_api.controller;

import com.github.brms5.personal_finance_api.controller.request.FinancialAssetRequest;
import com.github.brms5.personal_finance_api.controller.response.FinancialAssetResponse;
import com.github.brms5.personal_finance_api.dto.FinancialAssetDto;
import com.github.brms5.personal_finance_api.mapper.FinancialAssetDtoMapper;
import com.github.brms5.personal_finance_api.mapper.FinancialAssetResponseMapper;
import com.github.brms5.personal_finance_api.service.FinancialAssetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/financial-assets")
@RequiredArgsConstructor
public class FinancialAssetController {

    private final FinancialAssetService financialAssetService;

    @PostMapping("/createNewFinancialAsset")
    public ResponseEntity<FinancialAssetResponse> createFinancialAsset(@RequestBody @Valid FinancialAssetRequest financialAssetRequest) {
        FinancialAssetDto financialAssetDto = FinancialAssetDtoMapper.mapToDto(financialAssetRequest);
        financialAssetService.addFinancialAsset(financialAssetDto);

        return ResponseEntity.ok(FinancialAssetResponseMapper.mapToResponse(financialAssetDto));
    }
}
