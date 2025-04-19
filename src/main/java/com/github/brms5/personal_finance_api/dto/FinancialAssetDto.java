package com.github.brms5.personal_finance_api.dto;

import com.github.brms5.personal_finance_api.enums.FinancialAssetTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Getter
@Setter
@Builder
public class FinancialAssetDto {

    private String id;
    private String accountId;
    private Month referenceMonth;
    private String name;
    private FinancialAssetTypeEnum type;
    private BigDecimal value;
    private LocalDate acquisitionDate;
    private String institution;
    private String notes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
