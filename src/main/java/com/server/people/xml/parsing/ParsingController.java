package com.server.people.xml.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jsoup.Connection;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ParsingController {

    @GetMapping("/parse")
    public String parseXmlWithXpath() throws Exception {

        String result = getResultOpenAPI();

        XmlParser xmlParser = new XmlParser(result);

        String expression = "//itemList/BUSSTOP_NM";

        NodeList nodeList = xmlParser.getNodeList(expression);

        StringBuffer sb = new StringBuffer();

        for(int i = 0 ; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getTextContent());
            sb.append(nodeList.item(i).getTextContent() + " ");
        }
        return sb.toString();

    }

    public String getResultOpenAPI() throws Exception{

        String address = "http://openapitraffic.daejeon.go.kr/api/rest/busRouteInfo/getStaionByRoute?busRouteId=30300001&serviceKey=";
        String serviceKey = "ERvgM5YJuigXEYahj%2FZwKcD13pTrKUYUZOwWRuamCJfozqcMh4xyI9iMPTApsOQTzGcTeRJH7KIHmywWmYxe1g%3D%3D";

        URL url = new URL(address+serviceKey);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        bufferedReader.close();


        return response.toString();
    }


}
