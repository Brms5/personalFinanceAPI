package com.github.brms5.personal_finance_api.controller.response;

import com.github.brms5.personal_finance_api.enums.IndexType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class InflationIndexResponse {

    private LocalDate date;
    private Double indexValue;
    private IndexType indexType;
}
