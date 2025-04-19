package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.response.InflationIndexResponse;
import com.github.brms5.personal_finance_api.dto.InflationIndexDto;

public class InflationIndexResponseMapper {

    public static InflationIndexResponse mapDtoToResponse(InflationIndexDto dto) {
        return InflationIndexResponse.builder()
                .date(dto.getDate())
                .indexValue(dto.getIndexValue())
                .indexType(dto.getIndexType())
                .build();
    }
}
