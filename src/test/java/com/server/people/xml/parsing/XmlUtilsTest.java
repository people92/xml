package com.server.people.xml.parsing;

import com.server.people.xml.create.XmlBody;
import com.server.people.xml.create.XmlHeader;
import com.server.people.xml.create.XmlParent;
import com.server.people.xml.parsing.util.XmlUtils;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
public class XmlUtilsTest {

    @Test
    void xmlUtilsToXmlTest() throws Exception{

        XmlHeader xmlHeader = XmlHeader.builder().mainId("TEST1").receiver("re").sender("se").build();
        XmlBody xmlBody = XmlBody.builder().code("t1").message("TEST").build();

        XmlParent xmlParent = XmlParent.builder().xmlBody(xmlBody).xmlHeader(xmlHeader).build();

        System.out.println(XmlUtils.toXml(xmlParent));
    }

    @Test
    void xmlUtilsToJsonTest() throws Exception {
        XmlHeader xmlHeader = XmlHeader.builder().mainId("TEST1").receiver("re").sender("se").build();
        XmlBody xmlBody = XmlBody.builder().code("t1").message("TEST").build();

        XmlParent xmlParent = XmlParent.builder().xmlBody(xmlBody).xmlHeader(xmlHeader).build();

        String xml = XmlUtils.toXml(xmlParent);

        System.out.println(XmlUtils.toJson(xml));
    }
}
