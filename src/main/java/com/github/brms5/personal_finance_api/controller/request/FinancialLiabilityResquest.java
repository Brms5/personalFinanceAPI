package com.github.brms5.personal_finance_api.controller.request;

import com.github.brms5.personal_finance_api.enums.FinancialLiabilityStatusEnum;
import com.github.brms5.personal_finance_api.enums.FinancialLiabilityTypeEnum;
import com.github.brms5.personal_finance_api.enums.PaymentFrequencyEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class FinancialLiabilityResquest {

    @NotNull(message = "Account ID cannot be null")
    private String accountId;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Type cannot be null")
    private FinancialLiabilityTypeEnum type;

    @NotNull(message = "Total amount cannot be null")
    private BigDecimal totalAmount;

    @NotNull(message = "Remaining amount cannot be null")
    private BigDecimal remainingAmount;

    @NotNull(message = "Interest rate cannot be null")
    private BigDecimal interestRate;

    @NotNull(message = "Start date cannot be null")
    private LocalDate nextPaymentDueDate;

    @NotNull(message = "Payment frequency cannot be null")
    private PaymentFrequencyEnum paymentFrequency;

    @NotNull(message = "Installments cannot be null")
    private int installments;

    @NotNull(message = "Currency cannot be null")
    private String currency;

    @NotNull(message = "Creditor cannot be null")
    private String creditor;

    @NotNull(message = "Status cannot be null")
    private FinancialLiabilityStatusEnum status;

    private String notes;
}
