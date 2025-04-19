package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.client.response.GetInflationIndexResponse;
import com.github.brms5.personal_finance_api.dto.InflationIndexDto;
import com.github.brms5.personal_finance_api.entity.InflationIndexEntity;

import java.time.LocalDate;

public class InflationIndexDtoMapper {

    public static InflationIndexDto mapEntityToDto (InflationIndexEntity entity) {
        return InflationIndexDto.builder()
                .date(entity.getDate())
                .indexValue(entity.getIndexValue())
                .indexType(entity.getIndexType())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static InflationIndexDto mapGetResponseToDto (GetInflationIndexResponse response) {
        return InflationIndexDto.builder()
                .date(LocalDate.parse(response.getData()))
                .indexValue(Double.parseDouble(response.getValor()))
                .build();
    }
}
