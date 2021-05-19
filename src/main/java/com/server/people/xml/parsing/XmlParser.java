package com.server.people.xml.parsing;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

public class XmlParser {

    private Document doc;
    private XPath xPath;

    public XmlParser(String xml) throws Exception {
        InputSource is = new InputSource((new StringReader(xml)));
        this.doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
        this.xPath = XPathFactory.newInstance().newXPath();
    }
    public NodeList getNodeList(String expression) throws Exception{
        return (NodeList) xPath.evaluate(expression, this.doc, XPathConstants.NODESET);
    }

    public static void main(String[] args) throws Exception {
        ParsingController parsingController = new ParsingController();
        String xml = parsingController.getResultOpenAPI();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        InputSource is = new InputSource(new StringReader(xml));

        Document doc = documentBuilder.parse(is);

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expression = "//itemList/BUSSTOP_NM";

        NodeList nodeList = (NodeList) xPath.evaluate(expression, doc, XPathConstants.NODESET);

        for(int i = 0 ; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getTextContent());
        }

    }
}
