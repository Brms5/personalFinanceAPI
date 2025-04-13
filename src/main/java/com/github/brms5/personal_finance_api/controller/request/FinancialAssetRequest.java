package com.github.brms5.personal_finance_api.controller.request;

import com.github.brms5.personal_finance_api.enums.FinancialAssetTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class FinancialAssetRequest {

    @NotNull(message = "Account ID cannot be null")
    private String accountId;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Type cannot be null")
    private FinancialAssetTypeEnum type;

    @NotNull(message = "Value cannot be null")
    private BigDecimal value;

    @NotNull(message = "Currency cannot be null")
    private String currency;

    @NotNull(message = "Acquisition date cannot be null")
    private LocalDate acquisitionDate;

    @NotNull(message = "Institution cannot be null")
    private String institution;

    @NotNull(message = "Is liquid cannot be null")
    private boolean isLiquid;

    private String notes;
}
