
package com.zhangying.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for weatherModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="weatherModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="detail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="img" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="max_tem" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="min_tem" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "weatherModel", propOrder = {
    "date",
    "detail",
    "img",
    "maxTem",
    "minTem"
})
public class WeatherModel {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected String detail;
    protected String img;
    @XmlElement(name = "max_tem")
    protected int maxTem;
    @XmlElement(name = "min_tem")
    protected int minTem;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the detail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetail(String value) {
        this.detail = value;
    }

    /**
     * Gets the value of the img property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImg() {
        return img;
    }

    /**
     * Sets the value of the img property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImg(String value) {
        this.img = value;
    }

    /**
     * Gets the value of the maxTem property.
     * 
     */
    public int getMaxTem() {
        return maxTem;
    }

    /**
     * Sets the value of the maxTem property.
     * 
     */
    public void setMaxTem(int value) {
        this.maxTem = value;
    }

    /**
     * Gets the value of the minTem property.
     * 
     */
    public int getMinTem() {
        return minTem;
    }

    /**
     * Sets the value of the minTem property.
     * 
     */
    public void setMinTem(int value) {
        this.minTem = value;
    }

}
