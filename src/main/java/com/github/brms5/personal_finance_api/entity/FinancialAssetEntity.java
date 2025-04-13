package com.github.brms5.personal_finance_api.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "financial_assets")
@Getter
@Setter
public class FinancialAssetEntity {

    @Id
    private String id;

    private String accountId;

    private String name;
    private String type;
    private BigDecimal value;
    private String currency;
    private LocalDate acquisitionDate;
    private String institution;
    private boolean isLiquid;
    private String notes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}