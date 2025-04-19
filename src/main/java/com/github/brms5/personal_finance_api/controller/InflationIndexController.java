package com.github.brms5.personal_finance_api.controller;

import com.github.brms5.personal_finance_api.controller.response.InflationIndexResponse;
import com.github.brms5.personal_finance_api.dto.InflationIndexDto;
import com.github.brms5.personal_finance_api.mapper.InflationIndexResponseMapper;
import com.github.brms5.personal_finance_api.service.InflationIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inflation-index")
@RequiredArgsConstructor
public class InflationIndexController {

    private final InflationIndexService inflationIndexService;

    @PostMapping("/createNewInflationIndex/{startDate}/{endDate}")
    public void createNewInflationIndex(@RequestParam String startDate, @RequestParam String endDate) {
        inflationIndexService.requestAndSaveInflationIndex(startDate, endDate);
    }

    @GetMapping("/isInflationIndexAlreadySaved")
    public ResponseEntity<List<InflationIndexResponse>> getAllInflationIndexByDate() {
        List<InflationIndexDto> inflationIndexDtoList = inflationIndexService.getAllInflationIndex();
        return ResponseEntity.ok(
                inflationIndexDtoList.stream()
                        .map(InflationIndexResponseMapper::mapDtoToResponse)
                        .toList()
        );
    }
}