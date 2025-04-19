package com.github.brms5.personal_finance_api.controller.response;

import com.github.brms5.personal_finance_api.enums.FinancialLiabilityStatusEnum;
import com.github.brms5.personal_finance_api.enums.FinancialLiabilityTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Getter
@Setter
@Builder
public class FinancialLiabilityResponse {

    private String accountId;
    private Month referenceMonth;
    private String name;
    private FinancialLiabilityTypeEnum type;
    private FinancialLiabilityStatusEnum status;
    private BigDecimal totalAmount;
    private BigDecimal remainingAmount;
    private BigDecimal interestRate;
    private int installments;
    private String creditor;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
