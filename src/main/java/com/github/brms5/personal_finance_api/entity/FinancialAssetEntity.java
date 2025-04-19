package com.github.brms5.personal_finance_api.entity;

import com.github.brms5.personal_finance_api.enums.FinancialAssetTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Document(collection = "financial_assets")
@Getter
@Setter
@Builder
public class FinancialAssetEntity {

    @Id
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