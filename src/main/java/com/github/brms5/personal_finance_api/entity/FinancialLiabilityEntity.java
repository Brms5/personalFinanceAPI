package com.github.brms5.personal_finance_api.entity;

import com.github.brms5.personal_finance_api.enums.FinancialLiabilityStatusEnum;
import com.github.brms5.personal_finance_api.enums.FinancialLiabilityTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Document(collection = "financial_liabilities")
@Getter
@Setter
@Builder
public class FinancialLiabilityEntity {

    @Id
    private String id;

    private String accountId;

    private Month referenceMonth;

    private String name;
    private FinancialLiabilityTypeEnum type;
    private FinancialLiabilityStatusEnum status;
    private BigDecimal totalAmount;
    private BigDecimal remainingAmount;
    private BigDecimal interestRate; // Taxa de juros
    private int installments; // Quantidade de parcelas
    private String creditor;
    private String notes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
