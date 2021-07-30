package com.server.people.xml.create;

import lombok.*;
import org.eclipse.persistence.oxm.annotations.XmlMarshalNullRepresentation;
import org.eclipse.persistence.oxm.annotations.XmlNullPolicy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XmlBody")
@XmlAccessorType(XmlAccessType.FIELD)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class XmlBody {

    @XmlElement(name = "code", nillable = true)
    private String code;

    @XmlElement(name = "message")
    private String message;

    @XmlElement(name = "sendDate", nillable = true)
    private String sendDate;
}
