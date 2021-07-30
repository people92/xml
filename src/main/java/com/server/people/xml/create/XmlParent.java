package com.server.people.xml.create;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XmlParent")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class XmlParent {

    @XmlElement(name = "XmlHeader", nillable = true)
    private XmlHeader xmlHeader;

    @XmlElement(name = "XmlBody", nillable = true)
    private XmlBody xmlBody;


}
