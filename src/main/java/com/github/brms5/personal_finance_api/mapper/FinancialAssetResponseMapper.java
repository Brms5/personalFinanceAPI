package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.response.FinancialAssetResponse;
import com.github.brms5.personal_finance_api.dto.FinancialAssetDto;

public class FinancialAssetResponseMapper {

    public static FinancialAssetResponse mapToResponse(FinancialAssetDto financialAssetDto) {
        return FinancialAssetResponse.builder()
                .accountId(financialAssetDto.getAccountId())
                .name(financialAssetDto.getName())
                .type(financialAssetDto.getType())
                .value(financialAssetDto.getValue())
                .currency(financialAssetDto.getCurrency())
                .acquisitionDate(financialAssetDto.getAcquisitionDate())
                .institution(financialAssetDto.getInstitution())
                .isLiquid(financialAssetDto.isLiquid())
                .notes(financialAssetDto.getNotes())
                .createdAt(financialAssetDto.getCreatedAt())
                .updatedAt(financialAssetDto.getUpdatedAt())
                .build();
    }
}
