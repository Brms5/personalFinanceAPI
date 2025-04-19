package com.github.brms5.personal_finance_api.controller.request;

import com.github.brms5.personal_finance_api.enums.FinancialLiabilityStatusEnum;
import com.github.brms5.personal_finance_api.enums.FinancialLiabilityTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Month;

@Getter
@Setter
@Builder
public class FinancialLiabilityUpdateRequest {

    @NotNull(message = "ID cannot be null")
    private String id;

    @NotNull(message = "Account ID cannot be null")
    private String accountId;

    @NotNull(message = "Reference month cannot be null")
    private Month referenceMonth;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Type cannot be null")
    private FinancialLiabilityTypeEnum type;

    @NotNull(message = "Status cannot be null")
    private FinancialLiabilityStatusEnum status;

    @NotNull(message = "Total amount cannot be null")
    private BigDecimal totalAmount;

    @NotNull(message = "Remaining amount cannot be null")
    private BigDecimal remainingAmount;

    @NotNull(message = "Interest rate cannot be null")
    private BigDecimal interestRate;

    @NotNull(message = "Installments cannot be null")
    private int installments;

    @NotNull(message = "Creditor cannot be null")
    private String creditor;

    private String notes;
}
