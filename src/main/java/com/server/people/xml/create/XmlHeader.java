package com.server.people.xml.create;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XmlHeader")
@XmlAccessorType(XmlAccessType.FIELD)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class XmlHeader {

    @XmlElement(name = "sender", nillable = true)
    private String sender;

    @XmlElement(name = "receiver", nillable = true)
    private String receiver;

    @XmlElement(name = "mainId", nillable = true)
    private String mainId;
}
