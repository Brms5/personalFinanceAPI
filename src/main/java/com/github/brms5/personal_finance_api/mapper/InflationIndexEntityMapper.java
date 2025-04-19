package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.client.response.GetInflationIndexResponse;
import com.github.brms5.personal_finance_api.entity.InflationIndexEntity;
import com.github.brms5.personal_finance_api.enums.IndexType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InflationIndexEntityMapper {

    public static InflationIndexEntity mapGetResponseToEntity (GetInflationIndexResponse response) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(response.getData(), formatter);

        return InflationIndexEntity.builder()
                .date(date)
                .indexValue(Double.parseDouble(response.getValor()))
                .indexType(IndexType.IPCA)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
