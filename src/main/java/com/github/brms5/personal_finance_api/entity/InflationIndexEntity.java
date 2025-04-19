package com.github.brms5.personal_finance_api.entity;

import com.github.brms5.personal_finance_api.enums.IndexType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "inflation_index")
@Getter
@Setter
public class InflationIndexEntity {

    @Id
    private String id;

    private LocalDate date;
    private Double indexValue;
    private IndexType indexType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
