package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.response.FinancialLiabilityResponse;
import com.github.brms5.personal_finance_api.dto.FinancialLiabilityDto;

public class FinancialLiabilityResponseMapper {

    public static FinancialLiabilityResponse mapDtoToResponse(FinancialLiabilityDto dto) {
        return FinancialLiabilityResponse.builder()
                .id(dto.getId())
                .accountId(dto.getAccountId())
                .referenceMonth(dto.getReferenceMonth())
                .name(dto.getName())
                .type(dto.getType())
                .totalAmount(dto.getTotalAmount())
                .remainingAmount(dto.getRemainingAmount())
                .interestRate(dto.getInterestRate())
                .installments(dto.getInstallments())
                .creditor(dto.getCreditor())
                .status(dto.getStatus())
                .notes(dto.getNotes())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
