package com.github.brms5.personal_finance_api.service;

import com.github.brms5.personal_finance_api.client.InflationIndexClient;
import com.github.brms5.personal_finance_api.client.response.GetInflationIndexResponse;
import com.github.brms5.personal_finance_api.dto.InflationIndexDto;
import com.github.brms5.personal_finance_api.mapper.InflationIndexDtoMapper;
import com.github.brms5.personal_finance_api.mapper.InflationIndexEntityMapper;
import com.github.brms5.personal_finance_api.repository.InflationIndexRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InflationIndexService {

    private final InflationIndexClient inflationIndexClient;
    private final InflationIndexRepository inflationIndexRepository;

    public void requestAndSaveInflationIndex(String startDate, String endDate) {
        if (Boolean.TRUE.equals(isInflationIndexAlreadySaved(startDate))) {
            return;
        }

        String format = "json";
        List<GetInflationIndexResponse> inflationIndexResponseList = inflationIndexClient.getInflationIndex(format, startDate, endDate);
        inflationIndexRepository.save(InflationIndexEntityMapper.mapGetResponseToEntity(inflationIndexResponseList.getFirst()));
    }

    public List<InflationIndexDto> getAllInflationIndex() {
        return inflationIndexRepository.findAll()
                .stream()
                .map(InflationIndexDtoMapper::mapEntityToDto)
                .toList();
    }

    private Boolean isInflationIndexAlreadySaved(String startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(startDate, formatter);
        return inflationIndexRepository.existsByDate(date);
    }
}