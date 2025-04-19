package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.response.FinancialAssetResponse;
import com.github.brms5.personal_finance_api.dto.FinancialAssetDto;

public class FinancialAssetResponseMapper {

    public static FinancialAssetResponse mapToResponse(FinancialAssetDto financialAssetDto) {
        return FinancialAssetResponse.builder()
                .accountId(financialAssetDto.getAccountId())
                .referenceMonth(financialAssetDto.getReferenceMonth())
                .name(financialAssetDto.getName())
                .type(financialAssetDto.getType())
                .value(financialAssetDto.getValue())
                .acquisitionDate(financialAssetDto.getAcquisitionDate())
                .institution(financialAssetDto.getInstitution())
                .notes(financialAssetDto.getNotes())
                .createdAt(financialAssetDto.getCreatedAt())
                .updatedAt(financialAssetDto.getUpdatedAt())
                .build();
    }
}
