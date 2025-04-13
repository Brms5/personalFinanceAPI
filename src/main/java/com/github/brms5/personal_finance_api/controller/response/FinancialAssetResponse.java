package com.github.brms5.personal_finance_api.controller.response;

import com.github.brms5.personal_finance_api.enums.FinancialAssetTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class FinancialAssetResponse {

    private String accountId;

    private String name;
    private FinancialAssetTypeEnum type;
    private BigDecimal value;
    private String currency;
    private LocalDate acquisitionDate;
    private String institution;
    private boolean isLiquid;
    private String notes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
