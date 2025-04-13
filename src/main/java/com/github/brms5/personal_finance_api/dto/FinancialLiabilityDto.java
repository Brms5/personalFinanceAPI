package com.github.brms5.personal_finance_api.dto;

import com.github.brms5.personal_finance_api.enums.FinancialLiabilityStatusEnum;
import com.github.brms5.personal_finance_api.enums.FinancialLiabilityTypeEnum;
import com.github.brms5.personal_finance_api.enums.PaymentFrequencyEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class FinancialLiabilityDto {

    private String accountId;
    private String name;
    private FinancialLiabilityTypeEnum type;
    private BigDecimal totalAmount;
    private BigDecimal remainingAmount;
    private BigDecimal interestRate;
    private LocalDate nextPaymentDueDate;
    private PaymentFrequencyEnum paymentFrequency;
    private int installments;
    private String currency;
    private String creditor;
    private FinancialLiabilityStatusEnum status;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
