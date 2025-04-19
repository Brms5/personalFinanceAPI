package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.request.FinancialLiabilityCreateRequest;
import com.github.brms5.personal_finance_api.controller.request.FinancialLiabilityUpdateRequest;
import com.github.brms5.personal_finance_api.dto.FinancialLiabilityDto;
import com.github.brms5.personal_finance_api.entity.FinancialLiabilityEntity;

import java.time.LocalDateTime;

public class FinancialLiabilityDtoMapper {

    public static FinancialLiabilityDto mapCreateRequestToDto(FinancialLiabilityCreateRequest financialLiabilityCreateRequest) {
        return FinancialLiabilityDto.builder()
                .accountId(financialLiabilityCreateRequest.getAccountId())
                .referenceMonth(financialLiabilityCreateRequest.getReferenceMonth())
                .name(financialLiabilityCreateRequest.getName())
                .type(financialLiabilityCreateRequest.getType())
                .totalAmount(financialLiabilityCreateRequest.getTotalAmount())
                .remainingAmount(financialLiabilityCreateRequest.getRemainingAmount())
                .interestRate(financialLiabilityCreateRequest.getInterestRate())
                .installments(financialLiabilityCreateRequest.getInstallments())
                .creditor(financialLiabilityCreateRequest.getCreditor())
                .status(financialLiabilityCreateRequest.getStatus())
                .notes(financialLiabilityCreateRequest.getNotes())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static FinancialLiabilityDto mapUpdateRequestToDto(FinancialLiabilityUpdateRequest financialLiabilityUpdateRequest) {
        return FinancialLiabilityDto.builder()
                .id(financialLiabilityUpdateRequest.getId())
                .accountId(financialLiabilityUpdateRequest.getAccountId())
                .referenceMonth(financialLiabilityUpdateRequest.getReferenceMonth())
                .name(financialLiabilityUpdateRequest.getName())
                .type(financialLiabilityUpdateRequest.getType())
                .totalAmount(financialLiabilityUpdateRequest.getTotalAmount())
                .remainingAmount(financialLiabilityUpdateRequest.getRemainingAmount())
                .interestRate(financialLiabilityUpdateRequest.getInterestRate())
                .installments(financialLiabilityUpdateRequest.getInstallments())
                .creditor(financialLiabilityUpdateRequest.getCreditor())
                .status(financialLiabilityUpdateRequest.getStatus())
                .notes(financialLiabilityUpdateRequest.getNotes())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static FinancialLiabilityDto mapEntityToDto(FinancialLiabilityEntity financialLiabilityEntity) {
        return FinancialLiabilityDto.builder()
                .accountId(financialLiabilityEntity.getAccountId())
                .referenceMonth(financialLiabilityEntity.getReferenceMonth())
                .name(financialLiabilityEntity.getName())
                .type(financialLiabilityEntity.getType())
                .totalAmount(financialLiabilityEntity.getTotalAmount())
                .remainingAmount(financialLiabilityEntity.getRemainingAmount())
                .interestRate(financialLiabilityEntity.getInterestRate())
                .installments(financialLiabilityEntity.getInstallments())
                .creditor(financialLiabilityEntity.getCreditor())
                .status(financialLiabilityEntity.getStatus())
                .notes(financialLiabilityEntity.getNotes())
                .createdAt(financialLiabilityEntity.getCreatedAt())
                .updatedAt(financialLiabilityEntity.getUpdatedAt())
                .build();
    }
}
