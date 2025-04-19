package com.github.brms5.personal_finance_api.client;

import com.github.brms5.personal_finance_api.client.response.GetInflationIndexResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "inflation-index-client", url = "${url.inflation-index-client}")
public interface InflationIndexFeignClient {

    @GetMapping("/bcdata.sgs.10844/dados")
    List<GetInflationIndexResponse> getInflationIndex(
            @RequestParam("formato") String format,
            @RequestParam("dataInicial") String startDate,
            @RequestParam("dataFinal") String endDate
    );
}