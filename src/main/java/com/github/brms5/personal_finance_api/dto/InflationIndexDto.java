package com.github.brms5.personal_finance_api.dto;

import com.github.brms5.personal_finance_api.enums.IndexType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class InflationIndexDto {

    private LocalDate date;
    private Double indexValue;
    private IndexType indexType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
