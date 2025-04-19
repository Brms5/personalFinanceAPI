package com.github.brms5.personal_finance_api.controller.request;

import com.github.brms5.personal_finance_api.enums.FinancialAssetTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Getter
@Setter
@Builder
public class FinancialAssetCreateRequest {

    @NotNull(message = "Account ID cannot be null")
    private String accountId;

    @NotNull(message = "Reference month cannot be null")
    private Month referenceMonth;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Type cannot be null")
    private FinancialAssetTypeEnum type;

    @NotNull(message = "Value cannot be null")
    private BigDecimal value;

    @NotNull(message = "Acquisition date cannot be null")
    private LocalDate acquisitionDate;

    @NotNull(message = "Institution cannot be null")
    private String institution;

    private String notes;
}
