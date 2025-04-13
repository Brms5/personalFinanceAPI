package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.response.FinancialLiabilityResponse;
import com.github.brms5.personal_finance_api.dto.FinancialLiabilityDto;

public class FinancialLiabilityResponseMapper {

    public static FinancialLiabilityResponse mapToResponse(FinancialLiabilityDto dto) {
        return FinancialLiabilityResponse.builder()
                .accountId(dto.getAccountId())
                .name(dto.getName())
                .type(dto.getType())
                .totalAmount(dto.getTotalAmount())
                .remainingAmount(dto.getRemainingAmount())
                .interestRate(dto.getInterestRate())
                .nextPaymentDueDate(dto.getNextPaymentDueDate())
                .paymentFrequency(dto.getPaymentFrequency())
                .installments(dto.getInstallments())
                .currency(dto.getCurrency())
                .creditor(dto.getCreditor())
                .status(dto.getStatus())
                .notes(dto.getNotes())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
