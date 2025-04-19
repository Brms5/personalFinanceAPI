package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.request.FinancialAssetCreateRequest;
import com.github.brms5.personal_finance_api.controller.request.FinancialAssetUpdateRequest;
import com.github.brms5.personal_finance_api.dto.FinancialAssetDto;
import com.github.brms5.personal_finance_api.entity.FinancialAssetEntity;

import java.time.LocalDateTime;

public class FinancialAssetDtoMapper {

    public static FinancialAssetDto mapCreateRequestToDto(FinancialAssetCreateRequest financialAssetCreateRequest) {
        return FinancialAssetDto.builder()
                .accountId(financialAssetCreateRequest.getAccountId())
                .referenceMonth(financialAssetCreateRequest.getReferenceMonth())
                .name(financialAssetCreateRequest.getName())
                .type(financialAssetCreateRequest.getType())
                .value(financialAssetCreateRequest.getValue())
                .acquisitionDate(financialAssetCreateRequest.getAcquisitionDate())
                .institution(financialAssetCreateRequest.getInstitution())
                .notes(financialAssetCreateRequest.getNotes())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static FinancialAssetDto mapEntityToDto(FinancialAssetEntity financialAssetEntity) {
        return FinancialAssetDto.builder()
                .id(financialAssetEntity.getId())
                .accountId(financialAssetEntity.getAccountId())
                .referenceMonth(financialAssetEntity.getReferenceMonth())
                .name(financialAssetEntity.getName())
                .type(financialAssetEntity.getType())
                .value(financialAssetEntity.getValue())
                .acquisitionDate(financialAssetEntity.getAcquisitionDate())
                .institution(financialAssetEntity.getInstitution())
                .notes(financialAssetEntity.getNotes())
                .createdAt(financialAssetEntity.getCreatedAt())
                .updatedAt(financialAssetEntity.getUpdatedAt())
                .build();
    }

    public static FinancialAssetDto mapUpdateRequestToDto(FinancialAssetUpdateRequest financialAssetUpdateRequest) {
        return FinancialAssetDto.builder()
                .id(financialAssetUpdateRequest.getId())
                .accountId(financialAssetUpdateRequest.getAccountId())
                .referenceMonth(financialAssetUpdateRequest.getReferenceMonth())
                .name(financialAssetUpdateRequest.getName())
                .type(financialAssetUpdateRequest.getType())
                .value(financialAssetUpdateRequest.getValue())
                .acquisitionDate(financialAssetUpdateRequest.getAcquisitionDate())
                .institution(financialAssetUpdateRequest.getInstitution())
                .notes(financialAssetUpdateRequest.getNotes())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
