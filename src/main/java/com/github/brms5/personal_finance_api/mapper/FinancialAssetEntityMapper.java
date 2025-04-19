package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.dto.FinancialAssetDto;
import com.github.brms5.personal_finance_api.entity.FinancialAssetEntity;

public class FinancialAssetEntityMapper {

    public static FinancialAssetEntity mapToEntity(FinancialAssetDto dto) {
        return FinancialAssetEntity.builder()
                .accountId(dto.getAccountId())
                .referenceMonth(dto.getReferenceMonth())
                .name(dto.getName())
                .type(dto.getType())
                .value(dto.getValue())
                .acquisitionDate(dto.getAcquisitionDate())
                .institution(dto.getInstitution())
                .notes(dto.getNotes())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
