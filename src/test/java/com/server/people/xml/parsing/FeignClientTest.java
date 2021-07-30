package com.server.people.xml.parsing;

import com.server.people.xml.parsing.client.OpenAPIClient;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
public class FeignClientTest {

    @Autowired
    OpenAPIClient openAPIClient;

    @Test
    void getMethodFeignClientTest() {
        String serviceKey = "ERvgM5YJuigXEYahj%2FZwKcD13pTrKUYUZOwWRuamCJfozqcMh4xyI9iMPTApsOQTzGcTeRJH7KIHmywWmYxe1g%3D%3D";

        String reqPage = "1";

        String response = openAPIClient.getRouteInfoAll(serviceKey, reqPage);

        Assertions.assertNotNull(response);
    }
}
