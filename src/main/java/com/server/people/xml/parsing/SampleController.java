package com.server.people.xml.parsing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml")
public class SampleController {

    @GetMapping("/feign-test")
    public void testFeign()  {
        try {
            System.out.println("feign test");
            Thread.sleep(20000);
            System.out.println("feign end");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
