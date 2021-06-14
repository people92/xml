package com.server.people.xml.parsing.util;


import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class XmlUtils {

    public static String toXml(Object obj) throws Exception {

        JAXBContext jc = JAXBContext.newInstance(obj.getClass());

        Marshaller marshaller = jc.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        StringWriter writer = new StringWriter();

        marshaller.marshal(obj, writer);

        return writer.toString();
    }


    public static String getStringFromXml(String xml, String expression) throws Exception {

        InputSource is = new InputSource(new StringReader(xml));

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

        XPath xPath = XPathFactory.newInstance().newXPath();

        String result = (String) xPath.evaluate(expression, doc, XPathConstants.STRING);

        return result;

    }

    public static List<String> getListFromXml(String xml, String expression) throws Exception {

        InputSource is = new InputSource(new StringReader(xml));

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);

        XPath xPath = XPathFactory.newInstance().newXPath();

        List<String> result = new ArrayList<>();

        if(StringUtils.hasText(expression)) {
            NodeList nodeList = (NodeList) xPath.evaluate(expression, doc, XPathConstants.NODESET);
            for(int i = 0 ; i < nodeList.getLength(); i++) {
                result.add(i, nodeList.item(i).getTextContent());
            }
        }

        return result;
    }
}
