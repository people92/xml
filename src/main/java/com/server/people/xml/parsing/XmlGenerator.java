package com.server.people.xml.parsing;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlGenerator {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(XmlMappingDto.class);

        Marshaller marshaller = jc.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter writer = new StringWriter();

        XmlMappingDto xmlMappingDto = new XmlMappingDto();
        marshaller.marshal(xmlMappingDto, writer);

        System.out.println(writer.toString());
    }
}
