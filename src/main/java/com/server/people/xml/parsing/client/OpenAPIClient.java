package com.server.people.xml.parsing.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "open-api", url = "http://openapitraffic.daejeon.go.kr/api/rest/busRouteInfo/")
public interface OpenAPIClient {

    @GetMapping("/getRouteInfoAll")
    public String getRouteInfoAll(@RequestParam String serviceKey, @RequestParam String reqPage);

}
