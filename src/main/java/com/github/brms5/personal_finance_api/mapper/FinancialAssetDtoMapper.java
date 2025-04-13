package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.request.FinancialAssetRequest;
import com.github.brms5.personal_finance_api.dto.FinancialAssetDto;

import java.time.LocalDateTime;

public class FinancialAssetDtoMapper {

    public static FinancialAssetDto mapToDto(FinancialAssetRequest financialAssetRequest) {
        return FinancialAssetDto.builder()
                .accountId(financialAssetRequest.getAccountId())
                .name(financialAssetRequest.getName())
                .type(financialAssetRequest.getType())
                .value(financialAssetRequest.getValue())
                .currency(financialAssetRequest.getCurrency())
                .acquisitionDate(financialAssetRequest.getAcquisitionDate())
                .institution(financialAssetRequest.getInstitution())
                .isLiquid(financialAssetRequest.isLiquid())
                .notes(financialAssetRequest.getNotes())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
