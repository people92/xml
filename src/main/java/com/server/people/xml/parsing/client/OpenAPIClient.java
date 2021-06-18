package com.server.people.xml.parsing.client;

import com.server.people.xml.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${sample.open-api.name}", url = "${sample.open-api.url}", configuration = FeignConfiguration.class)
public interface OpenAPIClient {

    @GetMapping("/getRouteInfoAll")
    public String getRouteInfoAll(@RequestParam String serviceKey, @RequestParam String reqPage);

}
