package com.github.brms5.personal_finance_api.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Month;

@Getter
@Setter
@Builder
public class FinancialAssetReadRequest {

    @NotNull(message = "Account ID cannot be null")
    private String accountId;

    @NotNull(message = "Reference month cannot be null")
    private Month referenceMonth;
}
