package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.request.FinancialLiabilityResquest;
import com.github.brms5.personal_finance_api.dto.FinancialLiabilityDto;

import java.time.LocalDateTime;

public class FinancialLiabilityDtoMapper {

    public static FinancialLiabilityDto mapToDto(FinancialLiabilityResquest financialLiabilityResquest) {
        return FinancialLiabilityDto.builder()
                .accountId(financialLiabilityResquest.getAccountId())
                .name(financialLiabilityResquest.getName())
                .type(financialLiabilityResquest.getType())
                .totalAmount(financialLiabilityResquest.getTotalAmount())
                .remainingAmount(financialLiabilityResquest.getRemainingAmount())
                .interestRate(financialLiabilityResquest.getInterestRate())
                .nextPaymentDueDate(financialLiabilityResquest.getNextPaymentDueDate())
                .paymentFrequency(financialLiabilityResquest.getPaymentFrequency())
                .installments(financialLiabilityResquest.getInstallments())
                .currency(financialLiabilityResquest.getCurrency())
                .creditor(financialLiabilityResquest.getCreditor())
                .status(financialLiabilityResquest.getStatus())
                .notes(financialLiabilityResquest.getNotes())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
