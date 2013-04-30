package com.examples.ws.jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "refNumber" })
@XmlRootElement(name = "name" ,namespace="namespace")
public class JaxbExampleRoot {

	@XmlElement(required = true)
	protected String refNumber;

	/**
	 * Gets the value of the refNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRefNumber() {
		return refNumber;
	}

	/**
	 * Sets the value of the refNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRefNumber(String value) {
		this.refNumber = value;
	}
}
